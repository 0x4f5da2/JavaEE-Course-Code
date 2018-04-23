<%--
  Created by IntelliJ IDEA.
  User: chen1
  Date: 2018/4/19
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%
    if(session.getAttribute("username")==null || session.getAttribute("userid")==null){
%>
        <jsp:forward page="/logout"/>
<%
    }
%>
