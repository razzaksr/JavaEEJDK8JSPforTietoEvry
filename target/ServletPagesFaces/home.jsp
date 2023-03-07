<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 07-03-2023
  Time: 08:58 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setHeader("Expires","0");
    if(session.getAttribute("user")!=null){
%>
<a href="new.jsp">NEW</a>
<a href="list">List</a>
<a href="logout">Logout</a>
<%}else{
        response.sendRedirect("index.jsp");
}%>
</body>
</html>