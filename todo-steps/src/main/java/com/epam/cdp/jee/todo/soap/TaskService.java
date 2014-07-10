package com.epam.cdp.jee.todo.soap;

import java.util.List;

import com.epam.cdp.jee.todo.persistence.entity.Task;

public interface TaskService {

    List<Task> tasks();
}
