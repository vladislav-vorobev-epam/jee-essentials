package com.epam.cdp.jee.todo.persistence.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.persistence.Jdbc;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.entity.User;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;

@Stateless
@Jdbc
@Slf4j
public class TaskJdbcRepository implements TaskRepository {
    @Resource(name = "java:jboss/datasources/todoDS")
    private DataSource dataSource;

    @Override
    public void add(final Task task, final User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(final Task task) {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO tasks (id, name, due_datetime) VALUES(?, ?, ?)");
            statement.setLong(1, new Date().getTime());
            statement.setString(2, task.getName());
            statement.setTimestamp(3, new Timestamp(task.getDueDateTime().getMillis()));
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Unable to establish a connection.", e);
        }
    }

    @Override
    public void remove(final Task task) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Task> list() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Task> list(final User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Task findById(final Long taskId) {
        throw new UnsupportedOperationException();
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
