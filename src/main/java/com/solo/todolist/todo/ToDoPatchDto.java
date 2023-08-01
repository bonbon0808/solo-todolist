package com.solo.todolist.todo;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class ToDoPatchDto {
    @Positive
    private long titleId;

    private String title;

    private boolean completed;

    public void setTitleId(long titleId) {
        this.titleId = titleId;
    }
}
