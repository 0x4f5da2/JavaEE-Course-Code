<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chenzhicheng.course.javaee.exp3_1.model.AllHistoryBean" %>
<%@ page import="com.chenzhicheng.course.javaee.exp3_1.model.OneWeekHistoryBean" %><%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/23
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="session.jsp"%>
<html>
<head>
    <title>购物历史</title>
</head>
<body>
<a href="products">产品页面</a>&nbsp;||&nbsp;<a href="user">用户管理页面</a>&nbsp;||&nbsp;
<a href="history">购物历史</a>&nbsp;||&nbsp;<a href="logout">退出</a>
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
        ArrayList<AllHistoryBean> allList = (ArrayList)session.getAttribute("alllist");
        for(AllHistoryBean allBean : allList){
    %>
    <tr>
        <td><%=allBean.getProductcode()%></td>
        <td><%=allBean.getProductname()%></td>
        <td><%=allBean.getProductsource()%></td>
        <td><%=allBean.getNum()%></td>
    </tr>
    <%
        }
    %>
</table>
<hr>
<table>
    <caption>最近一周购物历史</caption>
    <tr>
        <td>产品编号</td>
        <td>产品名称</td>
        <td>产品供应商</td>
        <td>购买日期</td>
    </tr>
    <%
        ArrayList<OneWeekHistoryBean> oneList = (ArrayList)session.getAttribute("oneweeklist");
        for(OneWeekHistoryBean oneBean : oneList){
    %>
    <tr>
        <td><%=oneBean.getProductcode()%></td>
        <td><%=oneBean.getProductname()%></td>
        <td><%=oneBean.getProductsource()%></td>
        <td><%=oneBean.getShopdate()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>

