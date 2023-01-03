package com.delivery.servlets;

import com.delivery.Dependencies;
import com.delivery.db.TravelEntity;
import com.delivery.db.UserEntity;
import com.delivery.log.DeliveryLogger;
import com.delivery.services.MakeOrder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "OrderServlet", value = "/authorized/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int route_id = Integer.parseInt(req.getParameter("route_id"));
        TravelEntity travelEntity = Dependencies.travelEntityService.getById(route_id);
        int weight = Integer.parseInt(req.getParameter("weight"));
        int volume = Integer.parseInt(req.getParameter("volume"));

        UserEntity user = (UserEntity) req.getSession(true).getAttribute("userEntity");

        if (MakeOrder.make(user, travelEntity, weight, volume)) {
            Dependencies.deliveryLogger.log(DeliveryLogger.Level.INFO, "User " + user.getLogin() + " made new order.");
            resp.sendRedirect("/authorized/delivery_requests?error_message=Order+was+made+successfully");
        } else {
            Dependencies.deliveryLogger.log(DeliveryLogger.Level.WARNING, "Error while making order.");
            resp.sendRedirect("/authorized/delivery_requests?error_message=Error+while+making+order");
        }
    }
}
