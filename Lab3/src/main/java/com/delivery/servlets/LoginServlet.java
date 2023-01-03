package com.delivery.servlets;

import com.delivery.Dependencies;
import com.delivery.db.UserEntity;
import com.delivery.log.DeliveryLogger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login_page.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserEntity userEntity = Dependencies.userEntityService.getByLogin(login);

        if (userEntity == null) {
            resp.sendRedirect("/login?error_message=Invalid+login");
            return;
        }

        if (!Objects.equals(userEntity.getPassword(), password)) {
            resp.sendRedirect("/login?error_message=Invalid+password");
            return;
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("userEntity", userEntity);

        Dependencies.deliveryLogger.log(DeliveryLogger.Level.INFO, "User " + login + " login.");

        resp.sendRedirect("/home");
    }
}
