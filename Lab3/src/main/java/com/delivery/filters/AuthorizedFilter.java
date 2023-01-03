package com.delivery.filters;

import com.delivery.db.UserEntity;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthorizedFilter", urlPatterns = {"/authorized/*"})
public class AuthorizedFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

    @Override
    public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) _request;
        HttpServletResponse response = (HttpServletResponse) _response;

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("/login");
            return;
        }

        UserEntity userEntity = (UserEntity) session.getAttribute("userEntity");

        if (userEntity == null) {
            response.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
