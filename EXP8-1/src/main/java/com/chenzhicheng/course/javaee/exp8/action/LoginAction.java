package com.chenzhicheng.course.javaee.exp8.action;

import com.chenzhicheng.course.javaee.exp8.dao.LoginAndRegisterDao;
import com.chenzhicheng.course.javaee.exp8.dao.impl.LoginAndRegisterDaoImpl;
//todo pojo
import com.chenzhicheng.course.javaee.exp8.old.model.User;
import com.chenzhicheng.course.javaee.exp8.pojo.UsertableEntity;
import com.chenzhicheng.course.javaee.exp8.util.StringSupport;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User> {
    private User user = new User();
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
        if (session.get(StringSupport.SESSION_USER_BEAN) != null) {
            UsertableEntity tmp = (UsertableEntity) session.get(StringSupport.SESSION_USER_BEAN);
            if (tmp.getUsername().equals(this.user.getUsername()) && tmp.getPassword().equals(this.user.getPassword())) {
                return ActionSupport.SUCCESS;
            } else {
                session.remove(StringSupport.SESSION_USER_BEAN);
            }
        }
        LoginAndRegisterDao dao = new LoginAndRegisterDaoImpl();
        UsertableEntity entity = dao.login(this.user.getUsername(), this.user.getPassword());
        if (entity == null) {
            return ActionSupport.ERROR;
        } else {
            session.put("user_bean", entity);
            return ActionSupport.SUCCESS;
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

    /**
     * Gets the model to be pushed onto the ValueStack instead of the Action itself.
     *
     * @return the model
     */
    @Override
    public User getModel() {
        return this.user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * A default implementation that validates nothing.
     * Subclasses should override this method to provide validations.
     */
    @Override
    public void validate() {
        if (this.user.getUsername() == null || "".equals(this.user.getUsername())) {
            this.addFieldError("username", "USERNAME IS EMPTY");
        } else if (this.user.getPassword() == null || "".equals(this.user.getPassword())) {
            this.addFieldError("password", "PASSWORD IS EMPTY");
        }
    }
}
