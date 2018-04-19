<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/19
  Time: 13:34
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
    String productid = request.getParameter("pid");
    String uid = (String)session.getAttribute("userid");
    database.addShopRecord(uid, productid, "1");
%>
<jsp:forward page="products.jsp"/>
</body>
</html>
