<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 19.12.2016
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update record</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">
    <h2>Update information</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="weekday">Week day:</label>
                <input type="number" required min="1" max="7" value="${record.weekday}" class="form-control" name="weekday" id="weekday" placeholder="Enter week day">
            </div>
            <div class="form-group">
                <label for="startTime">Start time:</label>
                <input type="time" step="3600" required value="${record.startTime}" class="form-control" name="startTime" id="startTime" placeholder="Enter start time">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
