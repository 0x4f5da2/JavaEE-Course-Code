<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/18
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<jsp:useBean id="database" scope="application" class="com.chenzhicheng.course.javaee.exp2_3.DatabaseBean"/>
<%@ include file="session.jsp"%>
<html>
<head>
    <title>processing</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    database.addUser(username, password);
%>
<jsp:forward page="user.jsp"/>
</body>
</html>
