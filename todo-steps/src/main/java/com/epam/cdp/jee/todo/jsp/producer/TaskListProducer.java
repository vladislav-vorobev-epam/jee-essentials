package com.epam.cdp.jee.todo.jsp.producer;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;

@RequestScoped
@Named("taskListProducer")
public class TaskListProducer {

    @Inject
    @Jpa
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.list();
    }

    public List<Task> getTasks(final String tagName) {
        return taskRepository.list(tagName);
    }

}
