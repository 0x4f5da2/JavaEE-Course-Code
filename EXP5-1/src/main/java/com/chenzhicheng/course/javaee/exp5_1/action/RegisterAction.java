package com.chenzhicheng.course.javaee.exp5_1.action;

import com.chenzhicheng.course.javaee.exp5_1.database.Database;
import com.chenzhicheng.course.javaee.exp5_1.model.NewRegister;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class RegisterAction extends ActionSupport implements ModelDriven<NewRegister>, SessionAware {
    private NewRegister registerInfo = new NewRegister();
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
        Database database = new Database();
        boolean status = database.addUser(registerInfo.getUsername(), registerInfo.getPassword(), 0);
        database.close();
        if(status){
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
    public NewRegister getModel() {
        return this.registerInfo;
    }
}
