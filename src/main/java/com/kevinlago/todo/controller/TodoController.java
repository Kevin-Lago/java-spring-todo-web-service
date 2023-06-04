package com.kevinlago.todo.controller;

import com.kevinlago.todo.dao.Todo;
import com.kevinlago.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        try {
            return new ResponseEntity<>(todoService.getTodos(), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodo(
            @RequestParam("id") Long id
    ) {
        try {
            return new ResponseEntity<>(todoService.getTodo(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(
            @RequestBody Todo todo
    ) {
        try {
            return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity createTodo(
            @RequestParam("id") Long id
    ) {
        try {
            todoService.deleteTodo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Todo> updateTodo(
            @RequestBody Todo todo
    ) {
        try {
            return new ResponseEntity<>(todoService.updateToDo(todo), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
