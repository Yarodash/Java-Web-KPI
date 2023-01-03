<%@ page import="com.delivery.db.CityEntity" %>
<%@ page import="com.delivery.db.UserEntity" %>
<%@ page import="com.delivery.services.objects.CityEntityService" %>
<%@ page import="com.delivery.Dependencies" %>
<%@ page import="static com.delivery.Dependencies.cityEntityService" %>
<jsp:useBean id="travelEntity" scope="request" type="com.delivery.db.TravelEntity"/>
<jsp:useBean id="weight" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="volume" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="price" scope="request" type="java.lang.Integer"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Routes</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="content">
        <div class="center">
        <table class="styled-table-flipped">
            <tr><td>From: </td><td><%= cityEntityService.getById(travelEntity.getFromCityId()).getName() %></td></tr>
            <tr><td>To: </td><td><%= cityEntityService.getById(travelEntity.getToCityId()).getName() %></td></tr>
            <tr><td>Distance: </td><td><%= travelEntity.getDistance() %> km</td></tr>
            <tr><td>Price per kg:</td><td><%= travelEntity.getPricePerKg() %> ₴</td></tr>
            <tr><td>Weight:</td><td>${weight}</td></tr>
            <tr><td>Volume:</td><td>${volume}</td></tr>
            <tr><td>Price:</td><td>${price} ₴</td></tr>
        </table>
        <%
            UserEntity user = (UserEntity) request.getSession(true).getAttribute("userEntity");
            if (user != null) { %>
                <form action="/authorized/order" method="post">
                    <input type="hidden" name="route_id" value=<%=travelEntity.getId()%>>
                    <input type="hidden" name="weight" value=<%=weight%>>
                    <input type="hidden" name="volume" value=<%=volume%>>
                    <input class="submit" type="submit" value="Make order">
                </form>
            <% }
        %>
    </div></div>
</body>
</html>
