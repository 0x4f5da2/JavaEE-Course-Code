package com.chenzhicheng.course.javaee.exp8.old.model;

public class NewComment {
    public String title;
    public String content;

    public NewComment() {

    }

    public NewComment(String title, String content) {
        this.title = title;
        this.content = content;
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
}
