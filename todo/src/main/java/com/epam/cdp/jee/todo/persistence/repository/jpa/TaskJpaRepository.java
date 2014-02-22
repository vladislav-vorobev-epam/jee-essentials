package com.epam.cdp.jee.todo.persistence.repository.jpa;

import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.entity.User;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import lombok.extern.slf4j.Slf4j;

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

    @Override
    public List<Task> list() {
        List<Task> tasks;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> query = criteriaBuilder.createQuery(Task.class);
        query.distinct(true).from(Task.class);
        tasks = entityManager.createQuery(query).getResultList();
        return tasks;
    }

    @Override
    public List<Task> list(final User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Task findById(final Long taskId) {
        throw new UnsupportedOperationException();
    }
}
