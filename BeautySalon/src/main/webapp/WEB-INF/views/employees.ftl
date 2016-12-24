<html>
<head>
    <title>Employees</title>
<#include "head.ftl"></head>
<body>
<div class="container">
    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Last name</th>
            <th>First name</th>
            <th>Middle name</th>
            <th>Phone number</th>
            <th>Specialization</th>
            <th>Details</th>
        </tr>
        </thead>
        <#list employees as employee>
            <tr>
                <td>${employee.lastName!}</td>
                <td>${employee.firstName!}</td>
                <td>${employee.middleName!}</td>
                <td>${employee.phone!}</td>
                <td><a href="/employee/specialization/${employee.specialization.id!}">${employee.specialization.type!}</a></td>
                <td><a href="/employee/${employee.id!}">Details</a></td>
            </tr>
        </#list>
    </table>
</div>
<div class="container">
</div>
</body>
</html>
