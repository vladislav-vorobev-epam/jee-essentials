package com.epam.cdp.jee.todo.persistence.repository.jpa;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.entity.User;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;

@Stateless
@Slf4j
@Jpa
public class TaskJpaRepository implements TaskRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public void add(final Task task, final User user) {
        task.setUser(user);
        entityManager.merge(task);
    }

    @Override
    public void add(final Task task) {
        entityManager.merge(task);
    }

    @Override
    public void remove(final Task task) {
        entityManager.remove(task);
    }
}
