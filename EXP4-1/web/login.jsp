<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/26
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login_md</title>
</head>
<body>
<form action="login.action">
    <table>
        <caption>用户登录</caption>
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="user.username"/>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="user.password"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="登陆"/>
    <input type="reset" value="重置"/>

</form>

</body>
</html>
