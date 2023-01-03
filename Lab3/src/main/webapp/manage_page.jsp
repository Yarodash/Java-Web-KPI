<%@ page import="com.delivery.db.UserEntity" %>
<%@ page import="com.delivery.db.DeliveryRequestEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.delivery.db.TravelEntity" %>
<%@ page import="com.delivery.db.CityEntity" %>
<%@ page import="com.delivery.Dependencies" %>
<%@ page import="com.delivery.services.objects.DeliveryRequestEntityService" %>
<%@ page import="com.delivery.services.objects.TravelEntityService" %>
<%@ page import="com.delivery.services.objects.UserEntityService" %>
<%@ page import="static com.delivery.Dependencies.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage requests</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="content">
        <div class="center">
        <table class="styled-table">
            <thead>
                <tr>
                    <td>From</td>
                    <td>To</td>
                    <td>User</td>
                    <td>Weight</td>
                    <td>Volume</td>
                    <td>Price</td>
                    <td>Accept button</td>
                    <td>Decline button</td>
                    <td>Decline comment</td>
                </tr>
            </thead>
        <%
            List<DeliveryRequestEntity> requests = deliveryRequestEntityService.getWithoutReceiptAndDecline();
            for (DeliveryRequestEntity deliveryRequest: requests) {
                TravelEntity travelEntity = travelEntityService.getById(deliveryRequest.getTravelId());
                CityEntity fromCity = cityEntityService.getById(travelEntity.getFromCityId());
                CityEntity toCity = cityEntityService.getById(travelEntity.getToCityId());
                UserEntity user = userEntityService.getById(deliveryRequest.getUserId());%>
            <tr>
                <td><%=fromCity.getName()%></td>
                <td><%=toCity.getName()%></td>
                <td><%=user.getLogin()%></td>
                <td><%=deliveryRequest.getWeight()%></td>
                <td><%=deliveryRequest.getVolume()%></td>
                <td><%=deliveryRequest.getPrice()%></td>

                <form action="/admin/accept_request" method="post">
                    <input type="hidden" name="request_id" value=<%=deliveryRequest.getId()%>>
                    <td><input class="accept" type="submit" value="Accept"></td>
                </form>

                <form action="/admin/decline_request" method="post">
                    <input type="hidden" name="request_id" value=<%=deliveryRequest.getId()%>>
                    <td><input class="decline" type="submit" value="Decline"></td>
                    <td><input type="text" class="comment" name="comment" value="Sorry, your request was declined"></td>
                </form>
            </tr>
        <% } %>
        </table>
    </div></div>
</body>
</html>
