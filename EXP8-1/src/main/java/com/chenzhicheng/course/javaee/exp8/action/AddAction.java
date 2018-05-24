package com.chenzhicheng.course.javaee.exp8.action;

import com.chenzhicheng.course.javaee.exp8.database.Database;
//todo dao
import com.chenzhicheng.course.javaee.exp8.model.NewComment;
import com.chenzhicheng.course.javaee.exp8.model.User;
import com.chenzhicheng.course.javaee.exp8.util.CheckLoginState;
import com.chenzhicheng.course.javaee.exp8.util.StringSupport;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class AddAction extends ActionSupport implements ModelDriven<NewComment>, SessionAware {
    private NewComment comment = new NewComment();
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
        if (!CheckLoginState.check(session)) {
            return ActionSupport.LOGIN;
        }
        boolean status = false;
        Database database = new Database();
        status = database.addComment(
                Integer.toString(((User) session.get(StringSupport.SESSION_USER_BEAN)).getId()),
                comment.title, comment.content
        );
        if (status) {
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

    /**
     * Gets the model to be pushed onto the ValueStack instead of the Action itself.
     *
     * @return the model
     */
    @Override
    public NewComment getModel() {
        return comment;
    }
}
