package com.epam.cdp.jee.todo.soap;

import java.util.List;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebEndpoint;

import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;

@WebService
public class TaskWebService implements TaskService {

    @Inject
    @Jpa
    private TaskRepository taskRepository;

    @Override
    @WebMethod
    @WebEndpoint(name = "TaskWebService")
    public List<Task> tasks() {
        return taskRepository.list();
    }
}
