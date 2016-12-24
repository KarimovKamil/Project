<html>
<head>
    <title>Sign up</title>
<#include "head.ftl">
</head>
<body>
<div class="container">
    <h2>Registration</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" pattern="[1-9][0-9]{10}" class="form-control" required name="phone" id="phone"
                       placeholder="Enter phone">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" required class="form-control" name="password" id="pwd"
                       placeholder="Enter password">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">
            Sign up
        </button>
        <button class="btn btn-default" formmethod="get" onclick=location.href="/login">
            Sign in
        </button>
    </form>
</div>
</body>
</html>
