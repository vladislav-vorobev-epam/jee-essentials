package com.epam.cdp.jee.todo.servlet;

import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;
import lombok.NoArgsConstructor;

import com.epam.cdp.jee.todo.persistence.Task;
import com.epam.cdp.jee.todo.persistence.User;
import com.epam.cdp.jee.todo.repository.TaskRepository;
import com.epam.cdp.jee.todo.repository.UserRepository;

@WebServlet("/task")
@NoArgsConstructor
public class AddTaskServlet extends HttpServlet {

    @Inject
    private Logger log;

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private UserRepository userRepository;

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String taskName = request.getParameter("name");
        String dueDateParam = request.getParameter("dueDateParam");
        String pattern = "dd-mm-yyyy hh.mm.ss";
        Task task = new Task();
        task.setName(taskName);
        task.setDueDateTime(DateTimeFormat.forPattern(pattern).parseDateTime(dueDateParam));

        User user = userRepository.findByLogin(login);

        taskRepository.add(task, user);
    }
}
