<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="session.jsp"%>

<html>
<head>
    	<title>留言板</title>
</head>
<body bgcolor="#E3E3E3">
  	 <center>
  	 <form action="add.action" method="post">
  	          <table border="1">
  		 <caption>填写留言信息</caption>
  		 <tr><td>留言标题</td>
  		 <td><input type="text" name="title"/></td></tr>
  		 <tr><td>留言内容</td>
  		<td><textarea name="content" rows="5" cols="35"></textarea></td></tr>
  	           </table>
  		
                      <input type="submit" value="提交"/>
  	           <input type="reset" value="重置"/>
  	</form>
	</center>
</body>
</html>
