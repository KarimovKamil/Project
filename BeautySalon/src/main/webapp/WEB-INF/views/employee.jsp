<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 18.12.2016
  Time: 16:19
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
        <h2>Employee information</h2>
        <h3>Id: ${employee.id}<br>
            Last name: ${employee.lastName}<br>
            First name: ${employee.firstName}<br>
            Middle name: ${employee.middleName}<br>
            Phone: ${employee.phone}<br>
            Passport: ${employee.specialization.type}<br>
        </h3>

    </form>
    <div class="container">
        <table class="table table-striped table-bordered">
            <thead>
            <tr align="center">
                <th>Monday</th>
                <th>Tuesday</th>
                <th>Wednesday</th>
                <th>Thursday</th>
                <th>Friday</th>
                <th>Saturday</th>
                <th>Sunday</th>
            </tr>
            </thead>
            <tr>
                <td>${workTimes[0].startTime} - ${workTimes[0].endTime}</td>
                <td>${workTimes[1].startTime} - ${workTimes[1].endTime}</td>
                <td>${workTimes[2].startTime} - ${workTimes[2].endTime}</td>
                <td>${workTimes[3].startTime} - ${workTimes[3].endTime}</td>
                <td>${workTimes[4].startTime} - ${workTimes[4].endTime}</td>
                <td>${workTimes[5].startTime} - ${workTimes[5].endTime}</td>
                <td>${workTimes[6].startTime} - ${workTimes[6].endTime}</td>
            </tr>

        </table>
    </div>
    <form>
        <center>
            <button class="btn btn-primary" formaction="/employee/all" formmethod="get">
                Show all
            </button>
        </center>
    </form>
</div>
</body>
</html>
