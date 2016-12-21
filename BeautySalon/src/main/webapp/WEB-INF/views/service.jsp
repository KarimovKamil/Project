<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anteg
  Date: 18.12.2016
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Employee</title>
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
        <h2>Service information</h2>
        <h3>Type: ${service.type}<br>
            Price: ${service.price}<br>
        </h3>
    </form>
    <div class="container">
        <H2>Choose the employee</H2>
        <table class="table table-striped table-bordered">
            <thead>
            <tr align="center">
                <th>Last name</th>
                <th>First name</th>
                <th>Middle name</th>
                <th>Phone number</th>
                <th>Record</th>
            </tr>
            </thead>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.lastName}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.middleName}</td>
                    <td>${employee.phone}</td>
                    <td><a href="/service/${service.id}/employee/${employee.id}/record">Record</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <form>
        <center>
            <button class="btn btn-primary" formaction="/service/all" formmethod="get">
                Show all services
            </button>
        </center>
    </form>
</div>
</body>
</html>
