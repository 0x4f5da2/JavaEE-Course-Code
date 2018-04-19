<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/18
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<jsp:useBean id="database" scope="application" class="com.chenzhicheng.course.javaee.exp2_3.DatabaseBean"/>
<html>
<head>
    <title>购物历史</title>
</head>
<body>
<hr>
<table>
    <caption>历史购物总数</caption>
    <tr>
        <td>产品编号</td>
        <td>产品名称</td>
        <td>产品供应商</td>
        <td>产品数量</td>
    </tr>
    <%
        String uid = (String)session.getAttribute("userid");
        ResultSet resultSet = database.getClassfiedHistory(uid);
        while(resultSet.next()){
    %>
        <tr>
            <td><%=resultSet.getString("productcode")%></td>
            <td><%=resultSet.getString("productname")%></td>
            <td><%=resultSet.getString("productsource")%></td>
            <td><%=resultSet.getString("num")%></td>
        </tr>
    <%
        }
    %>
</table>
<hr>
<
<table>
    <caption>最近一周购物历史</caption>
    <tr>
        <td>产品编号</td>
        <td>产品名称</td>
        <td>产品供应商</td>
        <td>购买日期</td>
    </tr>
    <%
        resultSet = database.getOneWeekHistory(uid);
        while(resultSet.next()){
    %>
    <tr>
        <td><%=resultSet.getString("productcode")%></td>
        <td><%=resultSet.getString("productname")%></td>
        <td><%=resultSet.getString("productsource")%></td>
        <td><%=resultSet.getString("shopdate")%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
