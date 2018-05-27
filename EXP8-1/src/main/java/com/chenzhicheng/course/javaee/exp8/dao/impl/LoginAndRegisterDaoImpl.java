package com.chenzhicheng.course.javaee.exp8.dao.impl;

import com.chenzhicheng.course.javaee.exp8.dao.LoginAndRegisterDao;
import com.chenzhicheng.course.javaee.exp8.pojo.UsertableEntity;
import com.chenzhicheng.course.javaee.exp8.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class LoginAndRegisterDaoImpl implements LoginAndRegisterDao {
    @Override
    public UsertableEntity login(String username, String password) {
        Transaction transaction = null;
        Session session = HibernateSessionFactory.getSession();
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery("from UsertableEntity where username=? and password=?");
            query.setParameter(0, username);
            query.setParameter(1, password);
            UsertableEntity entity = (UsertableEntity) query.uniqueResult();
            transaction.commit();
            if(entity!=null){
                return entity;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
            return null;
        } finally {
            HibernateSessionFactory.closeSession();
        }

    }

    @Override
    public int register(String username, String password) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = null;
        Integer id = null;
        try {
            transaction = session.beginTransaction();
            UsertableEntity entity = new UsertableEntity();
            entity.setUsername(username);
            entity.setPassword(password);
            entity.setPermission(0);
            id = (Integer) session.save(entity);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
            return -1;
        } finally {
            HibernateSessionFactory.closeSession();
        }
        if(id != null){
            return id;
        } else {
            return -1;
        }
    }
}
