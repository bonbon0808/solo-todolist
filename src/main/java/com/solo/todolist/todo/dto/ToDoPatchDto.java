package com.solo.todolist.todo.dto;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class ToDoPatchDto {
    @Positive
    private long titleId;

    private String title;

    private int todoOrder;

    private boolean completed;


    public void setTitleId(long titleId) {
        this.titleId = titleId;
    }
}
