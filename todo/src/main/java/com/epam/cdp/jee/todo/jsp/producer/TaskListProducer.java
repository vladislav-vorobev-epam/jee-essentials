package com.epam.cdp.jee.todo.jsp.producer;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.joda.time.DateTime;

import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.google.common.collect.Lists;

@RequestScoped
public class TaskListProducer {

    // @Named provides access the return value via the EL variable name "tasks" in the JSP view
    @Produces
    @Named
    public List<Task> getTasks() {
        return Lists.newArrayList(new Task(1L, "Sample task", new DateTime()), new Task(2L, "One more sample task",
                new DateTime()));
    }

}
