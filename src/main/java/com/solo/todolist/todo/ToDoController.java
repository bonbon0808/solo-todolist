package com.solo.todolist.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todolist")
@Validated
public class ToDoController {

    private final ToDoService toDoService;
    private final ToDoMapper toDoMapper;

    public ToDoController(ToDoService toDoService, ToDoMapper toDoMapper) {
        this.toDoService = toDoService;
        this.toDoMapper = toDoMapper;
    }

    // create 할 일 목록 등록
    @PostMapping
    public ResponseEntity postList(@RequestBody ToDoPostDto toDoPostDtoDto) {
        ToDo toDo = toDoMapper.todoPostDtoTotodo(toDoPostDtoDto);

        ToDo response = toDoService.createToDoList(toDo);

        return new ResponseEntity<>(toDoMapper.todoToToDoResponseDto(response), HttpStatus.CREATED);
    }

    // update 할 일 내용 수정
    @PatchMapping("/{title-id}")
    public ResponseEntity patchList(@PathVariable("title-id") long titleId,
                                    @RequestBody ToDoPatchDto toDoPatchDto) {
        toDoPatchDto.setTitleId(titleId);


        ToDo response = toDoService.updateToDoList(toDoMapper.todoPatchDtoTotodo(toDoPatchDto));

        return new ResponseEntity<>(toDoMapper.todoToToDoResponseDto(response), HttpStatus.OK);
    }

    // read 전체 할일 목록 조회 , 특정 id로 조회
    @GetMapping("/{title-id}")
    public ResponseEntity findList(@PathVariable("title-id") long titleId) {

        ToDo response = toDoService.findToDoList(titleId);

        return new ResponseEntity<>(toDoMapper.todoToToDoResponseDto(response),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findLists() {
        List<ToDo> todos = toDoService.findToDoLists();

        List<ToDoResponseDto> response =
                todos.stream()
                        .map(toDo -> toDoMapper.todoToToDoResponseDto(toDo))
                        .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // delete 전체 할 일 삭제, 특정 id로 삭제
    @DeleteMapping("/{title-id}")
    public ResponseEntity deleteList(@PathVariable("title-id") @Positive long titleId) {
        System.out.println("# delete list");
        toDoService.deleteToDoList(titleId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity deleteLists() {
        System.out.println("# delete lists");
        toDoService.deleteToDoLists();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
