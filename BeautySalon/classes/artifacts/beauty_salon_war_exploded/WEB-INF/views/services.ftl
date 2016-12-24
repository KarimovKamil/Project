<html>
<head>
    <title>Services</title>
<#include "head.ftl"></head>
<body>
<div class="container">
    <H2>Choose service</H2>
    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Type</th>
            <th>Specialization</th>
            <th>Price</th>
            <th>Record</th>
        </tr>
        </thead>
        <#list services as service>
            <tr>
                <td>${service.type!}</td>
                <td><a href="/employee/specialization/${service.specialization.id!}">${service.specialization.type!}</a></td>
                <td>${service.price!}</td>
                <td><a href="/service/${service.id!}">Record</a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>
