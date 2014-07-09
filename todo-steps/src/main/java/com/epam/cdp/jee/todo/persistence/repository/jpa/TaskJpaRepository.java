package com.epam.cdp.jee.todo.persistence.repository.jpa;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;

@Stateless
@Slf4j
@Jpa
public class TaskJpaRepository implements TaskRepository {

    @Inject
    private EntityManager entityManager;

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
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> query = criteriaBuilder.createQuery(Task.class);
        Root<Task> taskRoot = query.from(Task.class);
        query.select(taskRoot);
        query.orderBy(criteriaBuilder.asc(taskRoot.get("dueDateTime")));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Task> list(final String tagName) {
        Query query = entityManager.createQuery("SELECT t FROM Task t INNER JOIN t.tags tag WHERE tag.name = :tagName ORDER BY t.dueDateTime ASC", Task.class);
        query.setParameter("tagName", tagName);
        return query.getResultList();
    }

    @Override
    public Task findById(final Long taskId) {
        throw new UnsupportedOperationException();
    }
}
