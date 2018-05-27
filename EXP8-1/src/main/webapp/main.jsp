<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <s:iterator var="each" value="#request.list">
            <tr>
                <td><s:property value="#each.usertableByUserId.username"/></td>
                <td><s:property value="#each.date"/></td>
                <td><s:property value="#each.title"/></td>
                <td><s:property value="#each.content"/></td>
            </tr>
        </s:iterator>

        <%--<%--%>
        <%--ArrayList al = (ArrayList) session.getAttribute(StringSupport.SESSION_LY_LIST);--%>
        <%--Iterator iter = al.iterator();--%>
        <%--while (iter.hasNext()) {--%>
        <%--LyTable ly = (LyTable) iter.next();--%>
        <%--%>--%>
        <%--<tr>--%>
        <%--<td><%= ly.getUsername() %>--%>
        <%--</td>--%>
        <%--<td><%= ly.getDate() %>--%>
        <%--</td>--%>
        <%--<td><%= ly.getTitle() %>--%>
        <%--</td>--%>
        <%--<td><%= ly.getContent() %>--%>
        <%--</td>--%>
        <%--</tr>--%>
        <%--<%--%>
        <%--}--%>
        <%--%>--%>
    </table>
    <input type="submit" value="留言"/>
</form>
</body>
</html>
