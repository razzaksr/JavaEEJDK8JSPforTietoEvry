<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 07-03-2023
  Time: 08:59 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>List Products</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setHeader("Expires","0");
    if(session.getAttribute("user")!=null){
%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
    <table>
        <thead>
            <tr><th>ID</th><th>Name</th><th>Price</th><th>Actions</th></tr>
        </thead>
        <tbody>
            <core:forEach var="every" items="${requestScope.all}">
                <tr>
                    <td>${every.id}</td><td>${every.name}</td><td>${every.price}</td>
                    <td>
                        <a href="edit?id=${every.id}">Edit</a>
                        <a href="delete?id=${every.id}">Delete</a>
                    </td>
                </tr>
            </core:forEach>
        </tbody>
    </table>
    <a href="logout">Logout</a>
    <%}else{
        response.sendRedirect("index.jsp");
        }%>
</body>
</html>
