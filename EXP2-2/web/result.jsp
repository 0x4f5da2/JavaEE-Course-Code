<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/16
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="studentBean" scope="session" class="com.chenzhicheng.course.javaee.exp2_2.Student"/>



<html>
<head>
    <title>结果</title>
</head>
<body>
姓名：<jsp:getProperty name="studentBean" property="username"/>
<br>
密码：<jsp:getProperty name="studentBean" property="password"/>
<br>
性别：<%=studentBean.isIsmale()?"男":"女"%>
<br>
年龄：<jsp:getProperty name="studentBean" property="age"/>
<br>
国籍：<jsp:getProperty name="studentBean" property="nationality"/>
<br>
电子邮件：<jsp:getProperty name="studentBean" property="email"/>
<br>
电话：<jsp:getProperty name="studentBean" property="telephone"/>


</body>
</html>
