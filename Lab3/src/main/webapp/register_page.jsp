<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register page</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <jsp:include page="show_error_message.jsp"/>
    <div class="content">
        <div class="center">
            <h2>Register page</h2>
            <form action="/register" method="post" class="login-form">
                <input placeholder="login" type="text" name="login" value="" autocomplete="off">
                <input placeholder="password" id="password" type="text" name="password" value="" autocomplete="off">
                <input class="submit" type="submit" value="Register">
            </form>
        </div>
    </div>
</body>
</html>
