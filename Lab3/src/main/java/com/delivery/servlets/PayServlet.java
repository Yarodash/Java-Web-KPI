package com.delivery.servlets;

import com.delivery.Dependencies;
import com.delivery.db.DeliveryRequestEntity;
import com.delivery.db.ReceiptEntity;
import com.delivery.db.UserEntity;
import com.delivery.services.PayOrder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PayServlet", value = "/authorized/pay")
public class PayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int receipt_id = Integer.parseInt(req.getParameter("receipt_id"));

        ReceiptEntity receiptEntity = Dependencies.receiptEntityService.getById(receipt_id);

        if (receiptEntity == null) {
            resp.sendRedirect("/home");
            return;
        }

        DeliveryRequestEntity deliveryRequest = Dependencies.deliveryRequestEntityService.getById(receiptEntity.getDeliveryRequestId());

        UserEntity user = (UserEntity) req.getSession(true).getAttribute("userEntity");

        if (deliveryRequest.getUserId() != user.getId()) {
            resp.sendRedirect("/home");
            return;
        }

        req.setAttribute("userEntity", user);
        req.setAttribute("deliveryRequest", deliveryRequest);
        req.setAttribute("receiptEntity", receiptEntity);
        req.getRequestDispatcher("/pay_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int receipt_id = Integer.parseInt(req.getParameter("receipt_id"));

        ReceiptEntity receiptEntity = Dependencies.receiptEntityService.getById(receipt_id);

        if (receiptEntity == null) {
            resp.sendRedirect("/home");
            return;
        }

        DeliveryRequestEntity deliveryRequest = Dependencies.deliveryRequestEntityService.getById(receiptEntity.getDeliveryRequestId());

        UserEntity user = (UserEntity) req.getSession(true).getAttribute("userEntity");

        if (deliveryRequest.getUserId() != user.getId()) {
            resp.sendRedirect("/home");
            return;
        }

        PayOrder.pay(receiptEntity);

        resp.sendRedirect("/authorized/delivery_requests");
    }
}
