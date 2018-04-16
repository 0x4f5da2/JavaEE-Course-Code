<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/16
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>
你好<% out.print(request.getParameter("username"));%>，欢迎登陆系统。
</body>
</html>
