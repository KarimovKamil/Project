<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Records</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">

    <h2>Your records</h2>

    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Id</th>
            <th>Type</th>
            <th>Employee first name</th>
            <th>Employee last name</th>
            <th>Weekday</th>
            <th>Start time</th>
            <th>End time</th>
        </tr>
        </thead>
        <c:forEach items="${records}" var="record">
            <tr>
                <td>${record.id}</td>
                <td>${record.svc.type}</td>
                <td>${record.employee.firstName}</td>
                <td>${record.employee.lastName}</td>
                <td>${record.weekday}</td>
                <td>${record.startTime}</td>
                <td>${record.endTime}</td>
                <td><form><button class="btn btn-primary" formaction="/profile/records/${record.id}" formmethod="get">
                    Details
                </button></form></td>
            </tr>
        </c:forEach>
    </table>



</div>
</body>
</html>
