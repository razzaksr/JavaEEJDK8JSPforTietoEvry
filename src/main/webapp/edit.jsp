<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 07-03-2023
  Time: 08:59 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setHeader("Expires","0");
    if(session.getAttribute("user")!=null){
%>
    <form action="update" method="post">
        <input type="hidden" name="id" value="${requestScope.single.id}">
        <input type="text" name="name" value="${requestScope.single.name}">
        <input type="text" name="price" value="${requestScope.single.price}">
        <input type="submit" value="Update">
    </form>
<a href="logout">Logout</a>
<%}else{
    response.sendRedirect("index.jsp");
}%>
</body>
</html>
