<%--
  Created by IntelliJ IDEA.
  User: anteg
  Date: 18.12.2016
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add record</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">
    <h2>Update your information</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="weekday">Weekday:</label>
                <input type="number" class="form-control" name="weekday" id="weekday" placeholder="Enter weekday">
            </div>
            <div class="form-group">
                <label for="startTime">Start time:</label>
                <input type="time" class="form-control" name="startTime" id="startTime" placeholder="Enter start time">
            </div>
            <div class="form-group">
                <label for="endTime">End time:</label>
                <input type="time" class="form-control" name="endTime" id="endTime" placeholder="Enter end time">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
