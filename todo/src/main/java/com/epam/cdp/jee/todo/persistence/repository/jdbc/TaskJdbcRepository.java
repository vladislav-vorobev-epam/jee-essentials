package com.epam.cdp.jee.todo.persistence.repository.jdbc;

import java.util.List;
import javax.ejb.Stateless;

import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.persistence.Jdbc;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.entity.User;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;

@Stateless
@Jdbc
@Slf4j
public class TaskJdbcRepository implements TaskRepository {
    @Override
    public void add(final Task task, final User user) {

    }

  @Override
  public void add(final Task task) {

  }

  @Override
    public void remove(final Task task) {

    }

  @Override
  public List<Task> list() {
        return null;
  }
}
