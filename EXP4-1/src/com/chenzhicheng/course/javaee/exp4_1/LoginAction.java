package com.chenzhicheng.course.javaee.exp4_1;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class LoginAction extends ActionSupport {
    private UserInfoBean user;

    @Override
    public String execute() throws Exception {
        Database database = new Database();
        boolean verified = false;
        try{
            verified = database.verify(user.getUsername(), user.getPassword())==null?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(verified) {
            Map session = ActionContext.getContext().getSession();
            session.put("logged_in", true);
            session.put("from", "LoginAction");
            return "success";
        } else {
            return "error";
        }
    }



    public UserInfoBean getUser() {
        return user;
    }

    public void setUser(UserInfoBean user) {
        this.user = user;
    }


}
