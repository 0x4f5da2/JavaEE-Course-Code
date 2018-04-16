<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/16
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form method="post" action="process.jsp">
    姓名：<input type="text" name="username"/>
    <br/>
    密码：<input type="password" name="password"/>
    <br/>
    性别：男<input type="radio" name="ismale" value="true"/>女<input type="radio" name="ismale" value="false"/>
    <br/>
    年龄：<input type="number" name="age"/>
    <br/>
    国籍：<input type="text" name="nationality"/>
    <br/>
    电子邮件：<input type="email" name="email"/>
    <br/>
    电话号码：<input type="text" name="tel"/>
    <br/>
    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/>
</form>

</body>
</html>
