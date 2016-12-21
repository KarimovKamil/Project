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
    <h2>Add time</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="weekday">Weekday:</label>
                <input type="number" class="form-control" name="weekday" id="weekday" placeholder="Enter weekday" required>
            </div>
            <div class="form-group">
                <label for="startTime">Start time:</label>
                <input type="time" class="form-control" name="startTime" id="startTime" placeholder="Enter start time" required>
            </div>
        </div>
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
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
