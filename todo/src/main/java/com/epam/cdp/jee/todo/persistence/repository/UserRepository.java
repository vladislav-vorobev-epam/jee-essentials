package com.epam.cdp.jee.todo.persistence.repository;

import com.epam.cdp.jee.todo.persistence.entity.User;

public interface UserRepository {

    User findByLogin(String login);

    User create(String login, String password);
}
