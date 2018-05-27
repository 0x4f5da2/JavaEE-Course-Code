package com.chenzhicheng.course.javaee.exp8.action;

import com.chenzhicheng.course.javaee.exp8.dao.LoginAndRegisterDao;
import com.chenzhicheng.course.javaee.exp8.dao.impl.LoginAndRegisterDaoImpl;
//todo pojo
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class RegisterAction extends ActionSupport implements SessionAware {
    private String username;
    private String password;
    private Map session;

    /**
     * A default implementation that does nothing an returns "success".
     *
     * <p>
     * Subclasses should override this method to provide their business logic.
     * </p>
     *
     * <p>
     * See also {@link Action#execute()}.
     * </p>
     *
     * @return returns {@link #SUCCESS}
     * @throws Exception can be thrown by subclasses.
     */
    @Override
    public String execute() throws Exception {
        LoginAndRegisterDao dao = new LoginAndRegisterDaoImpl();
        int id = dao.register(this.username, this.password);
        if (id != -1) {
            return ActionSupport.SUCCESS;
        } else {
            return ActionSupport.ERROR;
        }
    }

    /**
     * Sets the Map of session attributes in the implementing class.
     *
     * @param session a Map of HTTP session attribute name/value pairs.
     */
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
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
