<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 18.12.2016
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Profile</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Karma</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/employee/all">Employees</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <form>
        <h2>Your information</h2>
        <h3>Gender: ${customer.gender}<br>
            Last name: ${customer.lastName}<br>
            First name: ${customer.firstName}<br>
            Middle name: ${customer.middleName}<br>
            Phone: ${customer.phone}<br>
            Birth date: ${customer.birthDate}<br>
        </h3>
</div>
</body>
</html>
