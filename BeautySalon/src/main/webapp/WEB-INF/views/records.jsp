<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 18.12.2016
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Records</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">

    <h2>Your records</h2>

    <form>
        <c:forEach var="record" items="${records}">
            <tr>
                <td>Id: ${record.id}</td>
                <td>Type: ${record.svc.type}</td>
                <td>Employee first name: ${record.employee.firstName}</td>
                <td>Employee last name: ${record.employee.lastName}</td>
                <td>Weekday: ${record.weekday}</td>
                <td>Start time: ${record.startTime}</td>
                <td>End time: ${record.endTime}</td>
                <button class="btn btn-primary" formaction="/profile/records/${record.id}" formmethod="get">
                    Details
                </button>
            <tr/>
        </c:forEach>
    </form>

</div>
</body>
</html>
