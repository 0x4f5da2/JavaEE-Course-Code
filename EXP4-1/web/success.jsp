<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/26
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUCCESS</title>
</head>
<body>
<p style="color: green">SUCCESS</p>
<br>
<table>
    <tr>
        <td>
            logged_in:
        </td>
        <td>
            <%=session.getAttribute("logged_in").toString()%>
        </td>
    </tr>
    <tr>
        <td>
            from:
        </td>
        <td>
            <%=session.getAttribute("from").toString()%>
        </td>
    </tr>
</table>
</body>
</html>
