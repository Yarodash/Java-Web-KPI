package com.delivery.servlets;

import com.delivery.Dependencies;
import com.delivery.db.DeliveryRequestEntity;
import com.delivery.db.UserEntity;
import com.delivery.log.DeliveryLogger;
import com.delivery.services.MakeReceipt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AcceptRequestServlet", value = "/admin/accept_request")
public class AcceptRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int request_id = Integer.parseInt(req.getParameter("request_id"));
        DeliveryRequestEntity deliveryRequest = Dependencies.deliveryRequestEntityService.getById(request_id);

        UserEntity manager = (UserEntity) req.getSession().getAttribute("userEntity");

        MakeReceipt.make(deliveryRequest, manager);

        Dependencies.deliveryLogger.log(DeliveryLogger.Level.INFO, "Manager " + manager.getLogin() + " accepted request #" + request_id + ".");

        resp.sendRedirect("/admin/manage");
    }
}
