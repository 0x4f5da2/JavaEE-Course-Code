package com.chenzhicheng.course.javaee.exp4_1;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginActionMD implements ModelDriven<UserInfoBean>, Action, SessionAware {
    private UserInfoBean userInfoBean = new UserInfoBean();
    public Map session;

    @Override
    public String execute() throws Exception {
        Database database = new Database();
        boolean verifyed = false;
        try{
            verifyed = database.verify(userInfoBean.getUsername(), userInfoBean.getPassword())==null?false:true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(verifyed) {
            session.put("logged_in", true);
            session.put("from", "LoginActionMD");
            return "success";
        } else {
            return "error";
        }
    }

    @Override
    public UserInfoBean getModel() {
        return this.userInfoBean;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
