package com.epam.cdp.jee.todo.servlet;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;
import com.epam.cdp.jee.todo.persistence.repository.jpa.UserJpaRepository;

@WebServlet("/task/add.do")
@NoArgsConstructor
@Slf4j
public class AddTaskServlet extends HttpServlet {

    @Inject
    @Jpa
    private TaskRepository taskRepository;

    @Inject
    private UserJpaRepository userRepository;

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
        taskRepository.add(task);
        // TODO: add task assignment to user
    }
}
