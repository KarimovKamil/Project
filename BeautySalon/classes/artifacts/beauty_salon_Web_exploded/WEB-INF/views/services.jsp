<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 18.12.2016
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Services</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Karma</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/employee/all">Employee</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Id</th>
            <th>Type</th>
            <th>Specialization</th>
            <th>Price</th>
        </tr>
        </thead>
        <c:forEach items="${services}" var="service">
            <tr>
                <td><a href="/service/${service.id}">${service.id}</a></td>
                <td>${service.type}</td>
                <td><a href="/employee/specialization/${service.specialization.id}">${service.specialization.type}</a></td>
                <td>${service.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
