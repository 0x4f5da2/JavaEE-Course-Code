<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/15
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body bgcolor="#e3e3e3">
<form action="validate.jsp">
    <table>
        <caption>用户登录</caption>
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="username" size="20"/>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="password" size="21"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="登陆"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
