<%@ page import="com.delivery.db.UserEntity" %>
<%
    UserEntity user = (UserEntity) request.getSession(true).getAttribute("userEntity");
    if (user != null) { %>
    <div align="right" class="profile">
        <div class="right">
            <h1>Hello <%= user.getLogin() %></h1>
        </div>
    </div>
<% }%>

<div class="navbar">
    <div class="center">
        <a class="navbar" href="/home">Home</a>
        <a class="navbar" href="/register">Register</a>
        <a class="navbar" href="/login">Login</a>
        <a class="navbar" href="/routes">Delivery routes</a>
        <% if (user != null) { %>
            <a class="navbar" href="/authorized/delivery_requests">My delivery requests</a>
            <% if (user.getIsAdmin() != 0) { %>
                <a class="navbar admin_only" href="/admin/manage">Manage delivery requests</a>
                <a class="navbar admin_only" href="/admin/statistics">Statistics</a>
            <% } %>
            <a class="navbar" href="/logout">Logout</a>
        <% } %>
    </div>
</div>
