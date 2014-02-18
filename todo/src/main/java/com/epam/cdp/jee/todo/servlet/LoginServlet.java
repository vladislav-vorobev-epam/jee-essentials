package com.epam.cdp.jee.todo.servlet;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.NoArgsConstructor;

import com.epam.cdp.jee.todo.persistence.Jdbc;
import com.epam.cdp.jee.todo.persistence.repository.UserRepository;
import com.google.common.base.Strings;

@WebServlet("/login.do")
@NoArgsConstructor
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    @Inject
    @Jdbc
    private UserRepository userRepository;

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (Strings.isNullOrEmpty(password) || "wrong".equals(password)) {
            LOGGER.warn("Login failure, redirect to proper page");
            response.sendRedirect(request.getContextPath() + "/errors/login_failure.jsp");
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", login);
            userRepository.findByLogin(login);
            response.sendRedirect(request.getContextPath() + "/app.jsp");
        }
    }
}
