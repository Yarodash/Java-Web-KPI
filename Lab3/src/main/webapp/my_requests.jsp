<%@ page import="java.util.List" %>
<%@ page import="com.delivery.db.*" %>
<%@ page import="com.delivery.services.objects.*" %>
<%@ page import="com.delivery.Dependencies" %>
<%@ page import="static com.delivery.Dependencies.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My delivery requests</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="content">
        <div class="center">
    <%
        UserEntity user = (UserEntity) request.getSession(true).getAttribute("userEntity");
        List<DeliveryRequestEntity> deliveryRequests = deliveryRequestEntityService.getByUserId(user.getId());
        for (DeliveryRequestEntity deliveryRequest: deliveryRequests) {
            TravelEntity travelEntity = travelEntityService.getById(deliveryRequest.getTravelId());
            CityEntity fromCity = cityEntityService.getById(travelEntity.getFromCityId());
            CityEntity toCity = cityEntityService.getById(travelEntity.getToCityId());
    %>
            <div class="delivery_request">
                <h3 class="route_info">Route: <%=fromCity.getName()%> -> <%=toCity.getName()%></h3>
                <h3 class="route_info">Weight: <%=deliveryRequest.getWeight()%> kg</h3>
                <h3 class="route_info">Volume: <%=deliveryRequest.getVolume()%> litres</h3>
                <h3 class="route_info price">Price: <%=deliveryRequest.getPrice()%> ₴</h3>
                <h3 class="route_info">Order time: <%=deliveryRequest.getCreateTime()%></h3>

                <%
                    ReceiptEntity receiptEntity = deliveryRequestEntityService.getReceipt(deliveryRequest);

                    if (receiptEntity != null) {
                        if (receiptEntity.getIsPayed() != 0) {
                %><h3 class="route_info status">Status: Paid</h3><%
                        } else {
                %><h3 class="route_info status">Status: <a class="pay" href="/authorized/pay?receipt_id=<%=receiptEntity.getId()%>">Pay</a></h3><%
                        }
                    } else {

                        DeclineReasonEntity declineReasonEntity = deliveryRequestEntityService.getDeclineReason(deliveryRequest);

                        if (declineReasonEntity != null) {
                %>
                <h3 class="route_info status">Status: Declined</h3>
                <h3 class="route_info status">Reason: <%=declineReasonEntity.getComment()%></h3>
                <%} else {%>
                    <h3 class="route_info status">Status: Processed</h3>
                <%
                        }
                    }
                %>
            </div>
    <% } %>
    </div></div>
</body>
</html>
