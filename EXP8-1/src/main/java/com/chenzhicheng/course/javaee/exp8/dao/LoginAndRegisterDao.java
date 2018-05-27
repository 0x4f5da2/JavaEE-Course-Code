package com.chenzhicheng.course.javaee.exp8.dao;

import com.chenzhicheng.course.javaee.exp8.pojo.UsertableEntity;

public interface LoginAndRegisterDao {
    public UsertableEntity login(String username, String password);
    public int register(String username, String password);
}
