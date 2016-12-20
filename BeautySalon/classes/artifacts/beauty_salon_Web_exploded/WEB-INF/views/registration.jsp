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
    <title>Sign up</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">
    <h2>Enter your phone and password</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" pattern="[1-9][0-9]{10}" class="form-control" required name="phone" id="phone" placeholder="Enter phone">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" required class="form-control" name="password" id="pwd" placeholder="Enter password">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
