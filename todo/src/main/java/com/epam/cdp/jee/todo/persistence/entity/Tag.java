package com.epam.cdp.jee.todo.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
