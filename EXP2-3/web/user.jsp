<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/18
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<jsp:useBean id="database" scope="application" class="com.chenzhicheng.course.javaee.exp2_3.DatabaseBean"/>

<html>
<head>
    <title>用户操作页面</title>
</head>
<body>

<hr>

<form action="do_add_user.jsp" method="post">
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
            <td><<input type="reset" value="重置"></td>
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
        ResultSet resultSet = database.getUsers();
        while(resultSet.next()){
            %>
    <tr>
        <td><%=resultSet.getString("username")%></td>
        <td><%=resultSet.getString("password")%></td>
        <td><<a href="do_del_user.jsp?uid=<%=resultSet.getString("id")%>"></a></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
