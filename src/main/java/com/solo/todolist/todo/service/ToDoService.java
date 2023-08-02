package com.solo.todolist.todo.service;

import com.solo.todolist.todo.entity.ToDo;
import com.solo.todolist.todo.repository.ToDoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo createToDoList(ToDo toDo) {

        return toDoRepository.save(toDo);
    }

    public ToDo updateToDoList(long titleId, String title, int todoOrder, boolean completed) {
        ToDo toDo = toDoRepository.findById(titleId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        toDo.setTitle(title);
        toDo.setTodoOrder(todoOrder);
        toDo.setCompleted(completed);

        return toDoRepository.save(toDo);

    }

    public ToDo findToDoList(long titleId) {
        return toDoRepository.findById(titleId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public List<ToDo> findToDoLists() {
        return toDoRepository.findAll();
    }

    public void deleteToDoList(long titleId) {
        toDoRepository.deleteById(titleId);
    }

    public void deleteToDoLists() {
        toDoRepository.deleteAll();

    }

}
