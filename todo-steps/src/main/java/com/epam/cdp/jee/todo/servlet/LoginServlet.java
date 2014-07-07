package com.epam.cdp.jee.todo.servlet;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.common.base.Strings;

@WebServlet("/login.do")
@NoArgsConstructor
@Slf4j
public class LoginServlet extends HttpServlet {

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
            log.info("Login succeed, redirect to proper page");
            response.sendRedirect(request.getContextPath() + "/app.jsp");
        }
    }

}
