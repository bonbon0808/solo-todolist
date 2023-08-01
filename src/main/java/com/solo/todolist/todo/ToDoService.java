package com.solo.todolist.todo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    public ToDo createToDoList(ToDo toDo) {
        // business logic
        ToDo createToDoList = toDo;
        return createToDoList;
    }

    public ToDo updateToDoList(ToDo toDo) {
        // business logic

        // 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요
        ToDo updateToDoList = toDo;
        return updateToDoList;
    }

    public ToDo findToDoList(long titleId) {
        // business logic

        // 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요
        ToDo toDo =
                new ToDo(titleId,"복습하기", 1, true);
        return toDo;
    }

    public List<ToDo> findToDoLists() {
        // business logic

        // 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요
        List<ToDo> toDoList = List.of(
                new ToDo(1,"복습하기",2,false ),
                new ToDo(2,"학습하기",1, true)
        );
        return toDoList;
    }

    public void deleteToDoList(long titleId) {
        // business logic

        // 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요

    }

    public void deleteToDoLists() {
        // business logic

        // 나중에 DB에 저장 후, 되돌려 받는 것으로 변경 필요

    }

}
