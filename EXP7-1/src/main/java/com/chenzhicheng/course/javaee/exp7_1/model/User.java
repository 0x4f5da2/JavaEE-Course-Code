package com.chenzhicheng.course.javaee.exp7_1.model;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String username;
	private String password;
	private int permission;

	public User(){

    }

    public User(int id, String username, String password, int permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
