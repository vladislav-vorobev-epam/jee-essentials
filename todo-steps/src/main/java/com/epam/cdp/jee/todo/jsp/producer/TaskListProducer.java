package com.epam.cdp.jee.todo.jsp.producer;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.epam.cdp.jee.todo.persistence.Jdbc;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;

@RequestScoped
public class TaskListProducer {

    @Inject
    @Jdbc
    private TaskRepository taskRepository;

    // @Named provides access the return value via the EL variable name "tasks" in the JSP view
    @Produces
    @Named
    public List<Task> getTasks() {
        return taskRepository.list();
    }

}
