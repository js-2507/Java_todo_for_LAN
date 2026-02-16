package com.lan.todolist;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin
public class TodoController {

    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Todo> getTodos() {
        // Change this from repository.findAll()
        return repository.findAllSortedByPriority();
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        repository.deleteById(id);
    }
}