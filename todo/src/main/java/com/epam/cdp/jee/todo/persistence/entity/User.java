package com.epam.cdp.jee.todo.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
@Data
@NamedQuery(name = User.FIND_BY_LOGIN, query = "FROM User WHERE login = :login")
public class User implements Serializable {

    public static final String FIND_BY_LOGIN = "findByLogin";
    @Id
    @GeneratedValue
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Task> tasks = new HashSet<>();

}
