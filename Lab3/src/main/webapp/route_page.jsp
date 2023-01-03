<%@ page import="com.delivery.db.CityEntity" %>
<%@ page import="com.delivery.services.objects.CityEntityService" %>
<%@ page import="com.delivery.Dependencies" %>
<%@ page import="static com.delivery.Dependencies.cityEntityService" %>
<jsp:useBean id="travelEntity" scope="request" type="com.delivery.db.TravelEntity"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CityEntity fromCity = cityEntityService.getById(travelEntity.getFromCityId());
    CityEntity toCity = cityEntityService.getById(travelEntity.getToCityId());
%>
<html>
<head>
    <title>Route <%= fromCity.getName() %> -> <%= toCity.getName() %></title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="content">
        <div class="center">
        <table class="styled-table-flipped">
            <tr><td>From: </td><td><%= fromCity.getName() %></td></tr>
            <tr><td>To: </td><td><%= toCity.getName() %></td></tr>
            <tr><td>Distance: </td><td><%= travelEntity.getDistance()%> km</td></tr>
            <tr><td>Price per kg:</td><td><%= travelEntity.getPricePerKg() %> ₴</td></tr>
        </table>
        <form action="pre_order" method="post">
            <table>
                <tr>
                    <td><label for="weight">Weight in kg:</label></td>
                    <td><input id="weight" type="number" name="weight" value="" autocomplete="off"></td>
                </tr>
                <tr>
                    <td><label for="volume">Volume in litres:</label></td>
                    <td><input id="volume" type="number" name="volume" value="" autocomplete="off"></td>
                </tr>
            </table>
            <input type="hidden" name="route_id" value=${travelEntity.id}>
            <input class="submit" type="submit" value="Calculate price">
        </form>
    </div></div>
</body>
</html>
