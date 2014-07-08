package com.epam.cdp.jee.todo.servlet;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;

import com.epam.cdp.jee.todo.persistence.entity.Task;

@WebServlet("/task/add.do")
@NoArgsConstructor
@Slf4j
public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("username");
        String taskName = request.getParameter("name");
        String dueDateParam = request.getParameter("dueDateTime");
        Task task = new Task();
        task.setName(taskName);
        task.setDueDateTime(DateTimeFormat.forPattern("dd-MM-yyyy H:m").parseDateTime(dueDateParam));
        log.info("Is about to save new task.");
        response.sendRedirect(request.getContextPath() + "/app.jsp");
    }
}
