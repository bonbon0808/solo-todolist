package com.solo.todolist.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ToDoResponseDto {
    private long titleId;
    private String title;
    private int todoOrder;
    private boolean completed;
}
