<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/5/7
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.invalidate();
    response.sendRedirect("/login.jsp");
%>
