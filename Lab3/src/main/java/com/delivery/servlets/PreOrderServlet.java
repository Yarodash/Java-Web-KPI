package com.delivery.servlets;

import com.delivery.Dependencies;
import com.delivery.db.TravelEntity;
import com.delivery.services.PriceCalculator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PreOrderServlet", value = "/pre_order")
public class PreOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int route_id = Integer.parseInt(req.getParameter("route_id"));
        TravelEntity travelEntity = Dependencies.travelEntityService.getById(route_id);
        int weight = Integer.parseInt(req.getParameter("weight"));
        int volume = Integer.parseInt(req.getParameter("volume"));

        req.setAttribute("travelEntity", travelEntity);
        req.setAttribute("weight", weight);
        req.setAttribute("volume", volume);

        req.setAttribute("price", PriceCalculator.calculate_price(travelEntity, weight, volume));

        req.getRequestDispatcher("pre_order.jsp").forward(req, resp);
    }
}
