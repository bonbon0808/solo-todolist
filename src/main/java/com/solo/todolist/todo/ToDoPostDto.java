package com.solo.todolist.todo;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class ToDoPostDto {
    @Positive
    private long titleId;

    private String title;

    private int todoOrder;

    private boolean completed;



}
