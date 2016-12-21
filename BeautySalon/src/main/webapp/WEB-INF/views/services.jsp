<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 18.12.2016
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Services</title>
    <jsp:include page="head.jsp"/>
</head>
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
        <c:forEach items="${services}" var="service">
            <tr>
                <td>${service.type}</td>
                <td><a href="/employee/specialization/${service.specialization.id}">${service.specialization.type}</a></td>
                <td>${service.price}</td>
                <td><a href="/service/${service.id}">Record</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
