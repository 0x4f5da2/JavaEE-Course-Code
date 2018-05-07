<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.chenzhicheng.course.javaee.exp5_1.model.LyTable" %>
<%@ page import="com.chenzhicheng.course.javaee.exp5_1.util.StringSupport" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ include file="session.jsp" %>
<html>
<head>
    <title>留言板信息</title>
</head>
<body bgcolor="#E3E3E3">
<form action="liuyan.jsp" method="post">
    <table border="1">
        <caption>所有留言信息</caption>
        <tr>
            <th>留言人姓名</th>
            <th>留言时间</th>
            <th>留言标题</th>
            <th>留言内容</th>
        </tr>
        <%
            ArrayList al = (ArrayList) session.getAttribute(StringSupport.SESSION_LY_LIST);
            Iterator iter = al.iterator();
            while (iter.hasNext()) {
                LyTable ly = (LyTable) iter.next();
        %>
        <tr>
            <td><%= ly.getUsername() %>
            </td>
            <td><%= ly.getDate() %>
            </td>
            <td><%= ly.getTitle() %>
            </td>
            <td><%= ly.getContent() %>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <input type="submit" value="留言"/>
</form>
</body>
</html>
