<html>
<head>
    <title>Sign in</title>
<#include "head.ftl">

</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" pattern="[1-9][0-9]{10}" class="form-control" required name="phone" id="phone"
                       placeholder="Enter phone">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" required name="password" id="pwd"
                       placeholder="Enter password">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">
            Sign in
        </button>
        <button class="btn btn-default" formmethod="get" onclick=location.href="/registration">
            Sign up
        </button>
    </form>
</div>
</body>
</html>

