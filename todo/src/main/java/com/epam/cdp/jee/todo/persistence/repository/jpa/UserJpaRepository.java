package com.epam.cdp.jee.todo.persistence.repository.jpa;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.persistence.entity.User;

@Stateless
@Slf4j
public class UserJpaRepository {

    @Inject
    private EntityManager entityManager;

    public User findByLogin(final String login) {
        Query findByLoginQuery = entityManager.createNamedQuery(User.FIND_BY_LOGIN, User.class);
        findByLoginQuery.setParameter("login", login);
        User user = (User) findByLoginQuery.getSingleResult();
        return user;
    }
}
