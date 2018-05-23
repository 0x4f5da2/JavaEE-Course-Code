package com.chenzhicheng.course.javaee.exp7_1.action;

import com.chenzhicheng.course.javaee.exp7_1.database.Database;
import com.chenzhicheng.course.javaee.exp7_1.model.User;
import com.chenzhicheng.course.javaee.exp7_1.util.CheckLoginState;
import com.chenzhicheng.course.javaee.exp7_1.util.StringSupport;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Map;

public class LoadMessage extends ActionSupport implements SessionAware {
    public Map session;

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
        if (!CheckLoginState.check(session)) {
            return ActionSupport.LOGIN;
        }
        User user = (User) this.session.get(StringSupport.SESSION_USER_BEAN);
        if (user == null) {
            return ActionSupport.LOGIN;
        }
        Database database = new Database();
        ArrayList al = database.findLyInfo(user);
        this.session.put(StringSupport.SESSION_LY_LIST, al);
        database.close();
        return ActionSupport.SUCCESS;
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
}
