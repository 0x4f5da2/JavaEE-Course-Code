<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
     <title>简易留言板</title>
  </head>
  <body bgcolor="#E3E3E3">
		<form action="login.action" method="post">
			<table>
			<caption>用户登录</caption>
				<tr><td>登录名：</td>
				<td><input type="text" name="username"/></td>
				</tr><tr><td>密码:</td>
				<td><input type="password" name="password"/></td></tr>
			</table>
				<input type="submit" value="登录"/>
				<input type="reset" value="重置"/>
		</form>
		如果没注册单击<a href="register.jsp">这里</a>注册！
  </body>
</html>