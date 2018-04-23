<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chenzhicheng.course.javaee.exp3_1.model.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/23
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@include file="session.jsp"%>
<html>
<head>
    <title>用户操作页面</title>
</head>
<body>

<a href="products">产品页面</a>&nbsp;||&nbsp;<a href="user">用户管理页面</a>&nbsp;||&nbsp;
<a href="history">购物历史</a>&nbsp;||&nbsp;<a href="logout">退出</a>
<hr>

<form action="add_user" method="post">
    <table>
        <caption>增加用户</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"/> </td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"> </td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>

<hr>

<table>
    <caption>用户列表</caption>
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    <%
        ArrayList<UserBean> arrayList = (ArrayList<UserBean>) session.getAttribute("userlist");
        for(UserBean userBean:arrayList){
    %>
    <tr>
        <td><%=userBean.getUsername()%></td>
        <td><%=userBean.getPassword()%></td>
        <td><a href="del_user?uid=<%=userBean.getUserid()%>">删除用户</a></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
