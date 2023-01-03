<%@ page import="com.delivery.db.TravelEntity" %>
<%@ page import="com.delivery.db.CityEntity" %>
<%@ page import="com.delivery.db.ReceiptEntity" %>
<%@ page import="com.delivery.services.objects.TravelEntityService" %>
<%@ page import="com.delivery.services.objects.CityEntityService" %>
<%@ page import="com.delivery.Dependencies" %>
<%@ page import="static com.delivery.Dependencies.*" %>
<jsp:useBean id="userEntity" scope="request" type="com.delivery.db.UserEntity"/>
<jsp:useBean id="deliveryRequest" scope="request" type="com.delivery.db.DeliveryRequestEntity"/>
<jsp:useBean id="receiptEntity" scope="request" type="com.delivery.db.ReceiptEntity"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <%
        TravelEntity travelEntity = travelEntityService.getById(deliveryRequest.getTravelId());
        CityEntity fromCity = cityEntityService.getById(travelEntity.getFromCityId());
        CityEntity toCity = cityEntityService.getById(travelEntity.getToCityId());
    %>
    <div class="content">
        <div class="center">
        <div class="delivery_request">
            <h3 class="route_info">Route: <%=fromCity.getName()%> -> <%=toCity.getName()%></h3>
            <h3 class="route_into">Weight: <%=deliveryRequest.getWeight()%> kg</h3>
            <h3 class="route_into">Volume: <%=deliveryRequest.getVolume()%> litres</h3>
            <h3 class="route_into price">Price: <%=deliveryRequest.getPrice()%> ₴</h3>
            <h3 class="route_info">Order time: <%=deliveryRequest.getCreateTime()%></h3>
        </div>
        <form action="/authorized/pay" method="post">
            <input type="hidden" name="receipt_id" value=<%=receiptEntity.getId()%>>
            <input class="submit pay" type="submit" value="PAY">
        </form>
    </div></div>
</body>
</html>
