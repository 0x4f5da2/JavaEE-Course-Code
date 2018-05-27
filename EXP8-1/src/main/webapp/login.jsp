<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>简易留言板</title>
</head>
<body bgcolor="#E3E3E3">
<s:form action="login" method="POST" namespace="/">

    <table>
        <caption>用户登录</caption>
        <tr>
            <td rowspan="2"><s:textfield name="user.username" key="username" size="20"/> </td>
        </tr>
        <tr>
            <td rowspan="2"><s:textfield name="user.password" key="password" size="20"/> </td>
        </tr>
        <tr>
            <td><s:submit key="submit"/></td>
            <td><s:submit key="reset" /></td>
        </tr>
    </table>

</s:form>

<s:a href="register.jsp"><s:text name="signup"/></s:a>
</body>
</html>