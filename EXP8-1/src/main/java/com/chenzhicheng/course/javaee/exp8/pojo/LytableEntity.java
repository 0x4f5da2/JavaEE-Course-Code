package com.chenzhicheng.course.javaee.exp8.pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class LytableEntity {
    private int id;
//    private Integer userId;
    private Timestamp date;
    private String title;
    private String content;
    private UsertableEntity usertableByUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LytableEntity that = (LytableEntity) o;
        return id == that.id &&
//                Objects.equals(userId, that.userId) &&
                Objects.equals(date, that.date) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, /*userId, */date, title, content);
    }

    public UsertableEntity getUsertableByUserId() {
        return usertableByUserId;
    }

    public void setUsertableByUserId(UsertableEntity usertableByUserId) {
        this.usertableByUserId = usertableByUserId;
    }
}
