<%@ page import="com.delivery.db.TravelEntity" %>
<%@ page import="com.delivery.db.CityEntity" %>
<%@ page import="com.delivery.services.objects.CityEntityService" %>
<%@ page import="com.delivery.services.objects.TravelEntityService" %>
<%@ page import="com.delivery.Dependencies" %>
<%@ page import="static com.delivery.Dependencies.*" %>
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
            <div class="routes_sort">
                <a class="order_by" href="/routes?order_by=distance">Sort by distance</a>
                <a class="order_by" href="/routes?order_by=from_city">Sort by from city</a>
                <a class="order_by" href="/routes?order_by=price">Sort by price</a>
            </div>
            <table class="styled-table">
                <thead>
                    <tr>
                        <td>From</td>
                        <td>To</td>
                        <td>Distance</td>
                        <td>Price/kg</td>
                        <td>More info</td>
                    </tr>
                </thead>
            <%
                for (TravelEntity travelEntity: travelEntityService.getAll(request.getParameter("order_by"))) {%>
                <tr>
                    <td><%= cityEntityService.getById(travelEntity.getFromCityId()).getName() %></td>
                    <td><%= cityEntityService.getById(travelEntity.getToCityId()).getName() %></td>
                    <td><%= travelEntity.getDistance() %> km</td>
                    <td><%= travelEntity.getPricePerKg() %> ₴</td>
                    <td><a class="route" href="/route?route_id=<%= travelEntity.getId() %>">Order/Calculate price</a></td>
                </tr>
            <% } %>
            </table>
        </div>
    </div>
</body>
</html>
