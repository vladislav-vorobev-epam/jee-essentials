package com.epam.cdp.jee.todo.servlet;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.soap.client.Task;
import com.epam.cdp.jee.todo.soap.client.TaskWebService;
import com.epam.cdp.jee.todo.soap.client.TaskWebServiceService;

@WebServlet("/test.do")
@Slf4j
public class TestServlet extends HttpServlet {

    @Inject
    private EntityManager entityManager;

    @WebServiceRef(TaskWebServiceService.class)
    private TaskWebService service;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        List<Task> tasks = service.tasks();
        log.info("Here is a list of tasks: [{}]", tasks);
    }
}
