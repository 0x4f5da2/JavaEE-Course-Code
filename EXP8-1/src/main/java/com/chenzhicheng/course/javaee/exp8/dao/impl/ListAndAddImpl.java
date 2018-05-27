package com.chenzhicheng.course.javaee.exp8.dao.impl;

import com.chenzhicheng.course.javaee.exp8.dao.ListAndAddDao;
import com.chenzhicheng.course.javaee.exp8.old.model.NewComment;
import com.chenzhicheng.course.javaee.exp8.pojo.LytableEntity;
import com.chenzhicheng.course.javaee.exp8.pojo.UsertableEntity;
import com.chenzhicheng.course.javaee.exp8.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.List;

public class ListAndAddImpl implements ListAndAddDao {
    @Override
    public int add(NewComment comment, UsertableEntity usertableEntity) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = null;
        Integer id = null;
        try{
            transaction = session.beginTransaction();
            LytableEntity entity = new LytableEntity();
            entity.setContent(comment.getContent());
            entity.setTitle(comment.getTitle());
            entity.setDate(new Timestamp(System.currentTimeMillis()));
            entity.setUsertableByUserId(usertableEntity);
            id = (Integer) session.save(entity);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
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

    @Override
    public List getList(UsertableEntity entity) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = null;
        List<LytableEntity> list = null;
        try{
            transaction = session.beginTransaction();
            if(entity.getId()!=0){
                list = session.createQuery("from LytableEntity").list();
            } else {
                Query query =  session.createQuery("from LytableEntity where LytableEntity.usertableByUserId=?");
                query.setParameter(0, entity);
                list = query.list();
            }
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return list;
    }
}
