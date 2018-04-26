package com.chenzhicheng.course.javaee.exp4_1;

public class LoginAction {
    private String username;
    private String password;


    public String execute() throws Exception {
        Database database = new Database();
        boolean verifyed = false;
        try{
            verifyed = database.verify(this.username, this.password)==null?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(verifyed) {
            return "success";
        } else {
            return "error";
        }
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
}
