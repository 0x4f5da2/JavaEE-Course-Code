<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>简易留言板</title>
</head>
<body bgcolor="#E3E3E3">
<form action="login.action" method="post">
    <table>
        <caption>用户登录</caption>
        <tr>
            <td><s:textfield name="username" key="username" size="20"/> </td>
        </tr>
        <tr>
            <td><s:textfield name="password" key="password" size="20"/> </td>
        </tr>
    </table>
    <s:submit key="submit"/><s:reset key="reset"/>
</form>
<s:a href="register.jsp" key="signup"/>
</body>
</html>