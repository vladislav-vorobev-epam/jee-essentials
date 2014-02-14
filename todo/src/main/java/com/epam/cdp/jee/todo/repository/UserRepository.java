package com.epam.cdp.jee.todo.repository;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.epam.cdp.jee.todo.persistence.User;

@Stateless
public class UserRepository {

    @Inject
    private Logger log;

    @Inject
    private EntityManager entityManager;

    public User findByLogin(final String login) {
        Query findByLoginQuery = entityManager.createNamedQuery(User.FIND_BY_LOGIN, User.class);
        findByLoginQuery.setParameter("login", login);
        User user = (User) findByLoginQuery.getSingleResult();
        return user;
    }
}
