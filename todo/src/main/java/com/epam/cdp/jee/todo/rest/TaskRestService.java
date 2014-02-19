package com.epam.cdp.jee.todo.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;

@Path("/tasks")
@RequestScoped
public class TaskRestService {

    @Inject
    @Jpa
    private TaskRepository taskRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> tasks() {
        return taskRepository.list();
    }
}
