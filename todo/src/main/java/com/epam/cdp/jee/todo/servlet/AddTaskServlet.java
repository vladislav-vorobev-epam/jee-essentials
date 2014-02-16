package com.epam.cdp.jee.todo.servlet;

import java.io.IOException;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.persistence.Task;
import com.epam.cdp.jee.todo.persistence.User;
import com.epam.cdp.jee.todo.repository.TaskRepository;
import com.epam.cdp.jee.todo.repository.UserRepository;

@WebServlet("/task/add.do")
@NoArgsConstructor
@Slf4j
public class AddTaskServlet extends HttpServlet {

    @Inject
    private TaskRepository taskRepository;

    @Inject
    private UserRepository userRepository;

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("username");
        String taskName = request.getParameter("name");
        String dueDateParam = request.getParameter("dueDateTime");
        String pattern = "dd-MM-yyyy H:m";
        Task task = new Task();
        task.setName(taskName);
        task.setDueDateTime(DateTimeFormat.forPattern(pattern).parseDateTime(dueDateParam));

        try {
            User user = userRepository.findByLogin(login);
            taskRepository.add(task, user);
        } catch (NoResultException exc) {
            log.error("Unable to find user '{}'", login);
        }
    }
}
