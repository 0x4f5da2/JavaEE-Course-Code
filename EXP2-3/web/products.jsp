<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/18
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.ResultSet" errorPage="error.jsp" %>
<jsp:useBean id="database" scope="application" class="com.chenzhicheng.course.javaee.exp2_3.DatabaseBean"/>
<html>
<head>
    <title>商品操作页面</title>
</head>
<body>


<hr>
<form action="do_add_product.jsp" method="post">
    <table>
        <caption>增加商品</caption>
        <tr>
            <td>物品编号</td>
            <td><input type="text" name="productcode"/></td>
        </tr>
        <tr>
            <td>物品名称</td>
            <td><input type="text" name="productname"/> </td>
        </tr>
        <tr>
            <td>物品来源</td>
            <input type="text" name="productsource"/>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交"/>
            </td>
            <td>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
<hr>
<table>
    <caption>选择所需物品</caption>
    <tr>
        <td>物品编号</td>
        <td>物品名称</td>
        <td>物品来源</td>
        <td>操作</td>
    </tr>
    <%
        ResultSet resultSet = database.getProducts();
        while (resultSet.next()) {
    %>
    <tr>
        <td><%=resultSet.getString("productcode")%>
        </td>
        <td><%=resultSet.getString("productname")%>
        </td>
        <td><%=resultSet.getString("productsource")%>
        </td>
        <td>
            <a href="do_buy.jsp?pid=<%=resultSet.getString("id")%>">加入购物车</a>/
            <a href="do_del_product.jsp?pid=<%=resultSet.getString("id")%>">删除该物品</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
