package com.todo.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.model.Todo;
import com.todo.todo.service.TodoService;

@RestController
public class TodoController {
	@Autowired
	TodoService todoService;
	
	
	@PostMapping("/create-todo")
	public Todo createTodo(@RequestBody Todo requestTodo) {
		return todoService.createTodo(requestTodo);
	}
	@GetMapping("/get-todo/{userId}")
	public List<Todo> getTodos(@PathVariable int userId){
		return todoService.getTodos(userId);
	}
	
}
