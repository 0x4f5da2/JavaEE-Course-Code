<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/16
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="studentBean" scope="session" class="com.chenzhicheng.course.javaee.exp2_2.Student"/>

<html>
<head>
    <title>Processing</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("username");
    String password = request.getParameter("password");
    boolean ismale = Boolean.parseBoolean(request.getParameter("ismale"));
    int age = Integer.parseInt(request.getParameter("age"));
    String nationality = request.getParameter("nationality");
    String email = request.getParameter("email");
    String telephone = request.getParameter("tel");
%>
<jsp:setProperty name="studentBean" property="username" value="<%=name%>"/>
<jsp:setProperty name="studentBean" property="password" value="<%=password%>"/>
<jsp:setProperty name="studentBean" property="ismale" value="<%=ismale%>"/>
<jsp:setProperty name="studentBean" property="age" value="<%=age%>"/>
<jsp:setProperty name="studentBean" property="nationality" value="<%=nationality%>"/>
<jsp:setProperty name="studentBean" property="email" value="<%=email%>"/>
<jsp:setProperty name="studentBean" property="telephone" value="<%=telephone%>"/>

<jsp:forward page="./result.jsp"/>
</body>
</html>
