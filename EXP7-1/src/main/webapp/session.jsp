<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/5/7
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.chenzhicheng.course.javaee.exp7_1.util.StringSupport" %>
<%
    if (session.getAttribute(StringSupport.SESSION_USER_BEAN) == null) {
        response.sendRedirect("logout.jsp");
        return;
    }
%>
