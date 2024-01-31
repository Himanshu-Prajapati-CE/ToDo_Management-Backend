package com.management.todo.controller;


import com.management.todo.dto.ToDoDTO;
import com.management.todo.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    //Build Add ToDo Rest API
    @PostMapping
    public ResponseEntity<ToDoDTO> addToDo(@RequestBody ToDoDTO toDoDTO){

        ToDoDTO savedToDo = toDoService.addToDo(toDoDTO);
        return new ResponseEntity<>(savedToDo, HttpStatus.CREATED);
    }

    //Build Get ToDo Rest API
    @GetMapping("/{id}")
    public ResponseEntity<ToDoDTO> getTodo(@PathVariable("id") Long id){
        ToDoDTO todo = toDoService.getTodo(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    // Build Get All ToDos API
    @GetMapping
    public  ResponseEntity<List<ToDoDTO>> getAllToDos(){

        List<ToDoDTO> allTodos = toDoService.getAllTodos();
        return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    //Build Update TODO Rest API
    @PutMapping("/{id}")
    public ResponseEntity<ToDoDTO> updateTodo(@PathVariable("id") Long id, @RequestBody ToDoDTO updateToDo){

        ToDoDTO toDoDTO = toDoService.updateToDo(id, updateToDo);
        return new ResponseEntity<>(updateToDo, HttpStatus.OK);
    }

    //Build Delete TODO Rest API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable("id") Long id){
        toDoService.deleteTodo(id);
        return ResponseEntity.ok("Deleted!!");
    }

    //Build complete TODO Rest API
    @PatchMapping("{id}/complete")
    public ResponseEntity<ToDoDTO> competeToDo(@PathVariable Long id){
        ToDoDTO toDoDTO = toDoService.completeTodo(id);
        return ResponseEntity.ok(toDoDTO);
    }

    //Build Incomplete TODO Rest API
    @PatchMapping("{id}/incomplete")
    public ResponseEntity<ToDoDTO> inCompleteTodo(@PathVariable("id") Long id){
        ToDoDTO toDoDTO = toDoService.inCompleteToDo(id);
        return ResponseEntity.ok(toDoDTO);
    }
}
