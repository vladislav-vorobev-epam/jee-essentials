package com.epam.cdp.jee.todo.persistence.repository;

import java.util.List;

import com.epam.cdp.jee.todo.persistence.entity.Task;

public interface TaskRepository {

    void add(Task task);

    void remove(Task task);

    List<Task> list();

    List<Task> list(String tagName);

    Task findById(Long taskId);
}
