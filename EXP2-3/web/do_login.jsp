<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/18
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="database" scope="application" class="com.chenzhicheng.course.javaee.exp2_3.DatabaseBean"/>
<html>
<head>
    <title>processing</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String uid = database.verify(username, password);
    if (uid != null) {
        session.setAttribute("username", username);
        session.setAttribute("userid", uid);
%>
        <jsp:forward page="products.jsp"/>
<%
    } else {
%>
        <jsp:forward page="index.jsp?hint=loginerror"/>
<%
    }
%>
</body>
</html>
