package com.chenzhicheng.course.javaee.exp8.dao;

import com.chenzhicheng.course.javaee.exp8.old.model.NewComment;
import com.chenzhicheng.course.javaee.exp8.pojo.UsertableEntity;

import java.util.List;

public interface ListAndAddDao {
    public int add(NewComment newComment, UsertableEntity usertableEntity);
    public List getList(UsertableEntity entity);
}
