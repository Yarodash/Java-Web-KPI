<%@ page import="java.util.List" %>
<%@ page import="com.delivery.db.*" %>
<%@ page import="com.delivery.services.objects.CityEntityService" %>
<%@ page import="com.delivery.services.objects.TravelEntityService" %>
<%@ page import="com.delivery.services.objects.UserEntityService" %>
<%@ page import="com.delivery.services.objects.DeliveryRequestEntityService" %>
<%@ page import="com.delivery.Dependencies" %>
<%@ page import="static com.delivery.Dependencies.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserEntity manager = (UserEntity) request.getSession(true).getAttribute("userEntity");
%>
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
                    <td>Time</td>
                    <td>Status</td>
                </tr>
            </thead>
        <%
            List<DeliveryRequestEntity> requests = deliveryRequestEntityService.getAllByTime();
            for (DeliveryRequestEntity deliveryRequest: requests) {
                TravelEntity travelEntity = travelEntityService.getById(deliveryRequest.getTravelId());
                CityEntity fromCity = cityEntityService.getById(travelEntity.getFromCityId());
                CityEntity toCity = cityEntityService.getById(travelEntity.getToCityId());
                UserEntity user = userEntityService.getById(deliveryRequest.getUserId());
                ReceiptEntity receiptEntity = deliveryRequestEntityService.getReceipt(deliveryRequest);
                DeclineReasonEntity declineReasonEntity = deliveryRequestEntityService.getDeclineReason(deliveryRequest);%>
            <tr>
                <td><%=fromCity.getName()%></td>
                <td><%=toCity.getName()%></td>
                <td><%=user.getLogin()%></td>
                <td><%=deliveryRequest.getWeight()%></td>
                <td><%=deliveryRequest.getVolume()%></td>
                <td><%=deliveryRequest.getPrice()%></td>
                <td><%=deliveryRequest.getCreateTime()%></td>
                <td>
                    <%
                        if (receiptEntity != null) {
                            if (receiptEntity.getIsPayed() == 0) {
                                %><p class="not_paid">Not Paid</p><%
                            } else {
                                %><p class="paid">Paid</p><%
                            }
                        } else {
                            if (declineReasonEntity != null) {
                                %><p class="declined">Declined</p><%
                            } else {
                                %><p class="processing">Processing</p><%
                            }
                        }
                    %>
                </td>
            </tr>
        <% } %>
        </table>
        </div>
    </div>
</body>
</html>
