package com.epam.cdp.jee.todo.repository;

import com.epam.cdp.jee.todo.persistence.Task;
import com.epam.cdp.jee.todo.persistence.User;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class TaskRepository {

    @Inject
    private Logger log;

    @Inject
    private EntityManager entityManager;

    public void add(final Task task, final User user) {
        task.setUser(user);
        entityManager.merge(task);
    }

    public void remove(final Task task) {
        entityManager.remove(task);
    }
}
