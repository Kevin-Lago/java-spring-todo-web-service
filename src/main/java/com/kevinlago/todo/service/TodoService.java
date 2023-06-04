package com.kevinlago.todo.service;

import com.kevinlago.todo.repo.TodoRepo;
import com.kevinlago.todo.dao.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepo todoRepo;

    public List<Todo> getTodos() {
        return todoRepo.findAll();
    }

    public Todo getTodo(Long id) throws Exception {
        Optional<Todo> todo = todoRepo.findById(id);

        if (todo.isPresent()) {
            return todo.get();
        } else {
            throw new Exception("Entry not found");
        }
    }

    public Todo createTodo(Todo todo) {
        todo.setCreateDate(new Date());
        return todoRepo.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepo.deleteById(id);
    }

    public Todo updateToDo(Todo toDo) {
        return todoRepo.save(toDo);
    }
}
