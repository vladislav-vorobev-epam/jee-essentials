package com.epam.cdp.jee.todo.servlet;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;

import com.epam.cdp.jee.todo.DateFormatConstants;
import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.entity.Tag;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;
import com.google.common.base.Strings;

@WebServlet("/task/add.do")
@NoArgsConstructor
@Slf4j
public class AddTaskServlet extends HttpServlet {

    @Inject
    @Jpa
    private TaskRepository taskRepository;

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("username");
        String taskName = request.getParameter("name");
        String dueDateParam = request.getParameter("dueDateTime");
        Task task = new Task();
        task.setName(taskName);
        task.setDueDateTime(DateTimeFormat.forPattern(DateFormatConstants.DATE_TIME).parseDateTime(dueDateParam));

        String tagsParam = request.getParameter("tags");
        if (!Strings.isNullOrEmpty(tagsParam)) {
            Set<Tag> tagSet = new HashSet<>();
            String[] tags = tagsParam.split(",");
            for (int i = 0; i < tags.length; i++) {
                tagSet.add(new Tag(tags[i]));
            }
            task.setTags(tagSet);
        }
        log.info("Is about to save new task.");
        taskRepository.add(task);
        response.sendRedirect(request.getContextPath() + "/app.jsp");
    }
}
