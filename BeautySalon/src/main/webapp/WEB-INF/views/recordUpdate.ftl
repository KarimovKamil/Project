<html>
<head>
    <title>Update record</title>
<#include "head.ftl"></head>
<body>
<div class="container">
    <h2>Update information</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="weekday">Week day:</label>
                <input type="number" required min="1" max="7" value="${record.weekday!}" class="form-control"
                       name="weekday" id="weekday" placeholder="Enter week day">
            </div>
            <div class="form-group">
                <label for="startTime">Start time:</label>
                <input type="time" step="3600" required value="${record.startTime!}" class="form-control"
                       name="startTime" id="startTime" placeholder="Enter start time">
            </div>
        </div>

        <h2>Work time of this employee</h2>
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
                <td>${(workTimes[0].startTime)!} - ${(workTimes[0].endTime)!}</td>
                <td>${(workTimes[1].startTime)!} - ${(workTimes[1].endTime)!}</td>
                <td>${(workTimes[2].startTime)!} - ${(workTimes[2].endTime)!}</td>
                <td>${(workTimes[3].startTime)!} - ${(workTimes[3].endTime)!}</td>
                <td>${(workTimes[4].startTime)!} - ${(workTimes[4].endTime)!}</td>
                <td>${(workTimes[5].startTime)!} - ${(workTimes[5].endTime)!}</td>
                <td>${(workTimes[6].startTime)!} - ${(workTimes[6].endTime)!}</td>
            </tr>

        </table>
        <center>
            <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
        </center>
    </form>
</div>
</body>
</html>
