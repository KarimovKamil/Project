<html>
<head>
    <title>Records</title>
<#include "head.ftl"></head>
<body>
<div class="container">

    <h2>Your records</h2>

    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Type</th>
            <th>Employee first name</th>
            <th>Employee last name</th>
            <th>Weekday</th>
            <th>Start time</th>
            <th>Details</th>
        </tr>
        </thead>
        <#list records as record>
            <tr>
                <td>${record.svc.type!}</td>
                <td>${record.employee.firstName!}</td>
                <td>${record.employee.lastName!}</td>
                <td>${record.weekday!}</td>
                <td>${record.startTime!}</td>
                <td><a href="/profile/records/${record.id!}">Details</a></td>
            </tr>
        </#list>
    </table>



</div>
</body>
</html>
