<html>
<head>
    <title>Record</title>
<#include "head.ftl"></head>
<body>
<div class="container">

    <h2>#${record.id!} record</h2>

    <form>
        <h3>Type: ${record.svc.type!}<br>
            Employee first name: ${record.employee.firstName!}<br>
            Employee last name: ${record.employee.lastName!}<br>
            Weekday: ${record.weekday!}<br>
            Start time: ${record.startTime!}<br>
        </h3>
        <button class="btn btn-primary" formaction="/profile/records/${record.id!}/delete" formmethod="post">
            Delete
        </button>
        <button class="btn btn-primary" formaction="/profile/records/${record.id!}/update" formmethod="get">
            Update
        </button>
    </form>
</div>
</body>
</html>
