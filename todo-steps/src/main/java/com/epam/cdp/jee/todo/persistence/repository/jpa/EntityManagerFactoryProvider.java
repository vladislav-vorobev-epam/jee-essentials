package com.epam.cdp.jee.todo.persistence.repository.jpa;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class uses CDI to alias Java EE resources, such as the persistence context, to CDI beans
 * 
 * <p>
 * Example injection on a managed bean field:
 * </p>
 */
public class EntityManagerFactoryProvider {
    // use @SuppressWarnings to tell IDE to ignore warnings about field not being referenced
    // directly
    @SuppressWarnings("unused")
    @Produces
    @PersistenceContext
    private EntityManager entityManager;

}
