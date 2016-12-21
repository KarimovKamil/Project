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
    <title>Update profile</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">
    <h2>Update your information</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="firstName">First name:</label>
                <input type="text" required value="${customer.firstName}" class="form-control" name="firstName" id="firstName" placeholder="Enter firstname">
            </div>
            <div class="form-group">
                <label for="lastName">Last name:</label>
                <input type="text" required value="${customer.lastName}" class="form-control" name="lastName" id="lastName" placeholder="Enter lastname">
            </div>
            <div class="form-group">
                <label for="middleName">Middle name:</label>
                <input type="text" required value="${customer.middleName}" class="form-control" name="middleName" id="middleName" placeholder="Enter middlename">
            </div>
            <div class="form-group">
                <label for="gender">Gender:</label>
                <select name="gender" class="form-control" id="gender">
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                </select>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" required value="${customer.phone}" class="form-control" name="phone" id="phone" placeholder="Enter phone">
            </div>
            <div class="form-group">
                <label for="birthDate">Birth date:</label>
                <input type="date" min="1900-01-01" max="2002-01-01" required value="${customer.birthDate}" class="form-control" name="birthDate" id="birthDate" placeholder="Enter birth date">
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
