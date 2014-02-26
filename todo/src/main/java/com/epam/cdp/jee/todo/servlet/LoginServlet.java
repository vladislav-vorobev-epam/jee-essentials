package com.epam.cdp.jee.todo.servlet;

import java.io.IOException;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.jsp.producer.Principal;
import com.google.common.base.Strings;

@WebServlet("/login.do")
@NoArgsConstructor
@Slf4j
public class LoginServlet extends HttpServlet {

    @Inject
    private Event<Principal> principalEvent;

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (Strings.isNullOrEmpty(password) || "wrong".equals(password)) {
            log.warn("Login failure, redirect to proper page");
            response.sendRedirect(request.getContextPath() + "/errors/login_failure.jsp");
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", login);
            notifyUserLoggedIn(login);
            response.sendRedirect(request.getContextPath() + "/app.jsp");
        }
    }

    private void notifyUserLoggedIn(final String login) {
        Principal principal = new Principal();
        principal.setLogin(login);
        principalEvent.fire(principal);
    }
}
