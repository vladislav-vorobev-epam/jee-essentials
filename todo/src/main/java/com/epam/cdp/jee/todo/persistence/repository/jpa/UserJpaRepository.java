package com.epam.cdp.jee.todo.persistence.repository.jpa;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import lombok.extern.slf4j.Slf4j;

import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.entity.User;
import com.epam.cdp.jee.todo.persistence.repository.UserRepository;

@Stateless
@Slf4j
@Jpa
public class UserJpaRepository implements UserRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public User findByLogin(final String login) {
        Query findByLoginQuery = entityManager.createNamedQuery(User.FIND_BY_LOGIN, User.class);
        findByLoginQuery.setParameter("login", login);
        User user = (User) findByLoginQuery.getSingleResult();
        return user;
    }

    @Override
    public User create(final String login, final String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }
}
