package com.epam.cdp.jee.todo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@WebServlet("/user/add.do")
@NoArgsConstructor
@Slf4j
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.sendRedirect(request.getContextPath() + "/app.jsp");
    }

}
