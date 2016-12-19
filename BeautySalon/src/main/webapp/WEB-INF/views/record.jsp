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
    <title>Record</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">

    <h2>#${record.id} record</h2>

    <form>
        <h3>Id: ${record.id}<br>
            Type: ${record.svc.type}<br>
            Employee first name: ${record.employee.firstName}<br>
            Employee last name: ${record.employee.lastName}<br>
            Weekday: ${record.weekday}<br>
            Start time: ${record.startTime}<br>
            End time: ${record.endTime}<br>
        </h3>
    </form>

    <form><button class="btn btn-primary" formaction="/profile/records/${record.id}/update" formmethod="get">
        Update
    </button></form>
</div>
</body>
</html>
