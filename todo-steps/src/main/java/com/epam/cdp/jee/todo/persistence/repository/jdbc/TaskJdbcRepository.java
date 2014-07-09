package com.epam.cdp.jee.todo.persistence.repository.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.epam.cdp.jee.todo.DateFormatConstants;
import com.epam.cdp.jee.todo.persistence.Jdbc;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;

@Stateless
@Jdbc
@Slf4j
public class TaskJdbcRepository implements TaskRepository {

    @Resource(name = "java:jboss/datasources/todoDS")
    private DataSource dataSource;

    @Override
    public void add(final Task task) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO tasks (id, name, due_datetime) VALUES(?, ?, ?)")) {

                statement.setLong(1, new Date().getTime());
                statement.setString(2, task.getName());
                statement.setTimestamp(3, new Timestamp(task.getDueDateTime().getMillis()));
                statement.executeUpdate();
            }
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
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = getConnection()) {
            try (Statement statement = connection
                    .createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks ORDER BY due_datetime");
                while (resultSet.next()) {
                    long index = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    Timestamp dueDateRaw = Timestamp.valueOf(resultSet.getString("due_datetime"));
                    DateTime dueDateTime = new DateTime(dueDateRaw.getTime());
                    tasks.add(new Task(index, name, dueDateTime));
                }
            }
        } catch (SQLException e) {
            log.error("Unable to establish a connection.", e);
        }
        return tasks;
    }

    @Override
    public Task findById(final Long taskId) {
        throw new UnsupportedOperationException();
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
