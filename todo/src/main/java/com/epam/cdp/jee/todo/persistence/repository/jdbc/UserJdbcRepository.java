package com.epam.cdp.jee.todo.persistence.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.persistence.Jdbc;
import com.epam.cdp.jee.todo.persistence.entity.User;
import com.epam.cdp.jee.todo.persistence.repository.UserRepository;

@Stateless
@Slf4j
@Jdbc
public class UserJdbcRepository implements UserRepository {

    @Resource(name = "java:jboss/datasources/todoDS")
    private DataSource dataSource;

    @Override
    public User findByLogin(final String login) {
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ? ");
            statement.setString(1, login);
            statement.setMaxRows(1);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                return user;
            }
        } catch (SQLException e) {
            log.error("Unable to establish a connection.", e);
        }
        throw new NoResultException();
    }

    @Override
    public User create(final String login, final String password) {
        throw new UnsupportedOperationException();
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
