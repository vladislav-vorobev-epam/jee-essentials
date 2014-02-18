package com.epam.cdp.jee.todo.persistence.repository;

import java.util.List;

import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.entity.User;

public interface TaskRepository {

    void add(Task task, User user);

    void add(Task task);

    void remove(Task task);

    List<Task> list();

    List<Task> list(User user);
}
