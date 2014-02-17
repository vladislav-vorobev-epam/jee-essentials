package com.epam.cdp.jee.todo.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min = 10, max = 255)
    private String name;

    @Column(name = "due_datetime", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @OrderColumn
    private DateTime dueDateTime;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    private User user;
}
