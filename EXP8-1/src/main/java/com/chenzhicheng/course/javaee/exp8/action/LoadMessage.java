package com.chenzhicheng.course.javaee.exp8.action;

import com.chenzhicheng.course.javaee.exp8.dao.ListAndAddDao;
import com.chenzhicheng.course.javaee.exp8.dao.impl.ListAndAddImpl;
import com.chenzhicheng.course.javaee.exp8.database.Database;
//todo pojo
import com.chenzhicheng.course.javaee.exp8.pojo.UsertableEntity;
import com.chenzhicheng.course.javaee.exp8.util.CheckLoginState;
import com.chenzhicheng.course.javaee.exp8.util.StringSupport;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
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
        UsertableEntity entity = (UsertableEntity) this.session.get(StringSupport.SESSION_USER_BEAN);
//        Database database = new Database();
//        ArrayList al = database.findLyInfo(entity);
//        this.session.put(StringSupport.SESSION_LY_LIST, al);
//        database.close();
        ListAndAddDao dao = new ListAndAddImpl();
        List list = dao.getList(entity);
        if(list!=null) {
            Map request = (Map) ActionContext.getContext().get("request");
            request.put(StringSupport.REQUEST_LY_LIST, list);
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
}
