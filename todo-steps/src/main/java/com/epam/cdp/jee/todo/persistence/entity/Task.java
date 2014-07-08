package com.epam.cdp.jee.todo.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {

    private Long id;

    @NotEmpty
    @Size(min = 10, max = 255)
    private String name;

    private DateTime dueDateTime;

}
