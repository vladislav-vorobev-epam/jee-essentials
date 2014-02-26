package com.epam.cdp.jee.todo.persistence.entity;

import java.io.Serializable;

import org.joda.time.DateTime;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Task implements Serializable {

    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private DateTime dueDateTime;

}
