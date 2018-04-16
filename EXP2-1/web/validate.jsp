<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/15
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="ValidateBean" scope="page" class="com.chenzhicheng.course.javaee.exp2_1.ValidateBean"/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean verified = ValidateBean.validate(username, password);
        if(verified){
    %>
            <jsp:forward page="main.jsp"/>
    <%
        } else {
            %>
            <jsp:forward page="error.jsp"/>
    <%
        }
    %>
</body>
</html>
