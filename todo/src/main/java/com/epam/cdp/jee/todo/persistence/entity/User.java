package com.epam.cdp.jee.todo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.Data;

@Data
@NamedQuery(name = User.FIND_BY_LOGIN, query = "FROM User WHERE login = :login")
public class User implements Serializable {

    public static final String FIND_BY_LOGIN = "findByLogin";

    private long id;

    @NotNull
    @NotEmpty
    @Column(name = "login")
    @Size(min = 5, max = 250)
    @Email
    private String login;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 250)
    private String password;

}
