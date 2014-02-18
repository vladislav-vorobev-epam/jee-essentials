package com.epam.cdp.jee.todo.servlet;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.NoArgsConstructor;

import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.repository.UserRepository;

@WebServlet("/user/add.do")
@NoArgsConstructor
public class AddUserServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddUserServlet.class);

    @Inject
    @Jpa
    private UserRepository userRepository;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        userRepository.create(login, password);
        response.sendRedirect(request.getContextPath() + "/app.jsp");
    }

}
