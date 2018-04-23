<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chenzhicheng.course.javaee.exp3_1.model.ProductBean" %>
<%@ page import="com.chenzhicheng.course.javaee.exp3_1.servlet.ProductsServlet" %><%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/23
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="session.jsp"%>
<html>
<head>
    <title>商品操作页面</title>
</head>
<body>


<a href="products">产品页面</a>&nbsp;||&nbsp;<a href="user">用户管理页面</a>&nbsp;||&nbsp;
<a href="history">购物历史</a>&nbsp;||&nbsp;<a href="logout">退出</a>
<hr>
<form action="add_product" method="post">
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
            <td><input type="text" name="productsource"/></td>
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
        ArrayList<ProductBean> arrayList = (ArrayList)session.getAttribute("productlist");
        for(ProductBean productBean:arrayList) {
    %>
    <tr>
        <td><%=productBean.getProductcode()%>
        </td>
        <td><%=productBean.getProductname()%>
        </td>
        <td><%=productBean.getProductsource()%>
        </td>
        <td>
            <a href="do_buy?pid=<%=productBean.getProductid()%>">加入购物车</a>/
            <a href="del_product?pid=<%=productBean.getProductid()%>">删除该物品</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
