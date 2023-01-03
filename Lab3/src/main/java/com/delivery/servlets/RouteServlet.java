package com.delivery.servlets;

import com.delivery.Dependencies;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RouteServlet", value = "/route")
public class RouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int route_id = Integer.parseInt(request.getParameter("route_id"));

        request.setAttribute("travelEntity", Dependencies.travelEntityService.getById(route_id));

        request.getRequestDispatcher("route_page.jsp").forward(request, response);
    }
}
