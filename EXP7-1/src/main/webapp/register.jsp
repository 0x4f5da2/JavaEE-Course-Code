<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>简易留言板</title>
</head>
<body bgcolor="#E3E3E3">
<s:form action="register" method="POST">
    <table>
        <caption>用户注册</caption>
        <tr>
            <td>
                <s:textfield name="username" label="用户名"/>
            </td>
        </tr>
        <tr>
            <td>
                <s:password name="password" label="密码"/>
            </td>
        </tr>
    </table>
    <s:submit value="注册"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
