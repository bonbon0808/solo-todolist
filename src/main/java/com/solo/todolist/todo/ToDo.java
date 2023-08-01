package com.solo.todolist.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    private long titleId;
    private String title;
    private int todoOrder;
    private boolean completed;
}
