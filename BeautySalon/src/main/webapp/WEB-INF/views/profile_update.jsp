<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 18.12.2016
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Sign up</title>
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
    <h2>Update your information</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="firstName">Firstname:</label>
                <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Enter firstname">
            </div>
            <div class="form-group">
                <label for="lastName">Lastname:</label>
                <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Enter lastname">
            </div>
            <div class="form-group">
                <label for="middleName">Middlename:</label>
                <input type="text" class="form-control" name="middleName" id="middleName" placeholder="Enter middlename">
            </div>
            <div class="form-group">
                <label for="gender">Gender:</label>
                <input type="text" class="form-control" name="gender" id="gender" placeholder="Enter gender">
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" class="form-control" name="phone" id="phone" placeholder="Enter phone">
            </div>
            <div class="form-group">
                <label for="birthDate">Birthdate:</label>
                <input type="text" class="form-control" name="birthDate" id="birthDate" placeholder="Enter birth date">
            </div>
            <div class="form-group">
                <label for="hashPassword">Password:</label>
                <input type="password" class="form-control" name="hashPassword" id="hashPassword" placeholder="Enter password">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
