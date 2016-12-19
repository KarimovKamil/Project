<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 18.12.2016
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">
    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Id</th>
            <th>Last name</th>
            <th>First name</th>
            <th>Middle name</th>
            <th>Phone number</th>
            <th>Specialization</th>
        </tr>
        </thead>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td><a href="/employee/${employee.id}">${employee.id}</a></td>
                <td>${employee.lastName}</td>
                <td>${employee.firstName}</td>
                <td>${employee.middleName}</td>
                <td>${employee.phone}</td>
                <td><a href="/employee/specialization/${employee.specialization.id}">${employee.specialization.type}</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container">
    <%--<form>--%>
        <%--<center>--%>
            <%--<button class="btn btn-primary" formaction="/employee/add" formmethod="get">--%>
                <%--Add new--%>
            <%--</button>--%>
        <%--</center>--%>
    <%--</form>--%>
</div>
</body>
</html>
