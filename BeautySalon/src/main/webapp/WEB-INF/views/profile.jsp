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
    <title>Profile</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<div class="container">
    <form>
        <h2>Your information</h2>
        <h3>Gender: ${customer.gender}<br>
            Last name: ${customer.lastName}<br>
            First name: ${customer.firstName}<br>
            Middle name: ${customer.middleName}<br>
            Phone: ${customer.phone}<br>
            Birth date: ${customer.birthDate}<br>
        </h3>
        <button class="btn btn-primary" formaction="/profile/update" formmethod="get">
            Update
        </button>
        <button class="btn btn-primary" formaction="/profile/delete" formmethod="post">
            Delete me
        </button>
        <button class="btn btn-primary" formaction="/profile/records" formmethod="get">
            My records
        </button>
        <button class="btn btn-primary" formaction="/service/all" formmethod="get">
            Record
        </button>
    </form>
</div>
</body>
</html>
