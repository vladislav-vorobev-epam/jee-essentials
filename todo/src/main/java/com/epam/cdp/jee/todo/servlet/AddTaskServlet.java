package com.epam.cdp.jee.todo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.DateFormatConstants;
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
        Task task = new Task(1L, taskName, new DateTime());
        task.setName(taskName);
        task.setDueDateTime(DateTimeFormat.forPattern(DateFormatConstants.DATE_TIME).parseDateTime(dueDateParam));
        // TODO: add task assignment to user
        response.sendRedirect(request.getContextPath() + "/app.jsp");
    }
}
