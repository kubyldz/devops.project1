package com.example.devops.project1.controller;
import com.example.devops.project1.entity.Todo;
import com.example.devops.project1.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HelloController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/hello")
    public String sayHello() {
        return "Jenkins connected";
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }
}
