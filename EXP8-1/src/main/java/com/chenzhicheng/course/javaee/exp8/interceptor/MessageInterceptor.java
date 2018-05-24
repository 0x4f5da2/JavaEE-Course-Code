package com.chenzhicheng.course.javaee.exp8.interceptor;

import com.chenzhicheng.course.javaee.exp8.action.AddAction;
import com.chenzhicheng.course.javaee.exp8.database.Database;
//todo dao
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MessageInterceptor extends AbstractInterceptor {
    /**
     * Override to handle interception
     *
     * @param invocation
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        AddAction action = (AddAction) invocation.getAction();
        String title = action.getModel().getTitle();
        Database database = new Database();
        if (database.hasSameTitle(title)) {
            return Action.ERROR;
        } else {
            return invocation.invoke();
        }
    }
}
