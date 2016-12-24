<html>
<head>
    <title>Employee</title>
<#include "head.ftl"></head>
<body>
<div class="container">
    <form>
        <h2>Employee information</h2>
        <h3>Last name: ${employee.lastName!}<br>
            First name: ${employee.firstName!}<br>
            Middle name: ${employee.middleName!}<br>
            Phone: ${employee.phone!}<br>
            Passport: ${employee.specialization.type!}<br>
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
                <td>${(workTimes[0].startTime)!} - ${(workTimes[0].endTime)!}</td>
                <td>${(workTimes[1].startTime)!} - ${(workTimes[1].endTime)!}</td>
                <td>${(workTimes[2].startTime)!} - ${(workTimes[2].endTime)!}</td>
                <td>${(workTimes[3].startTime)!} - ${(workTimes[3].endTime)!}</td>
                <td>${(workTimes[4].startTime)!} - ${(workTimes[4].endTime)!}</td>
                <td>${(workTimes[5].startTime)!} - ${(workTimes[5].endTime)!}</td>
                <td>${(workTimes[6].startTime)!} - ${(workTimes[6].endTime)!}</td>
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
