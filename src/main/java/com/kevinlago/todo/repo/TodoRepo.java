package com.kevinlago.todo.repo;

import com.kevinlago.todo.dao.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, Long> {
}
