package com.todo.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todo.model.Todo;
import com.todo.todo.model.User;
import com.todo.todo.repository.TodoRepo;
import com.todo.todo.repository.UserRepo;

@Service
public class TodoService {

	@Autowired
	TodoRepo todoRepo;
	@Autowired
	UserRepo userRepo;
	public Todo createTodo(Todo requestTodo) {
		int userId=requestTodo.getUser().getUserId();
		User user=userRepo.findById(userId);
		if(user==null) {
			return null;
		}
		requestTodo.setUser(user);
		
		return todoRepo.save(requestTodo);
	}
	
	public List<Todo> getTodos(int userId){
		List<Todo> todoList=new ArrayList<>();
		User user=userRepo.findById(userId);
		if(user==null) {
			return null;
		}
		return todoList=user.getTodoList();
	}
	
	public void deleteTodo(int todoId)
	{
		Todo todo= todoRepo.findById(todoId);
		todoRepo.delete(todo);
	}
	
	public Todo updateTodo(Todo todo, int todoId)
	{
		Todo oldTodo= todoRepo.findById(todoId);
		if(oldTodo == null)
			throw new IllegalArgumentException("Todo with id " + todoId + " not found");
		if(todo.getTitle()!=null)
		{
			oldTodo.setTitle(todo.getTitle());
		}
		if(todo.getDescription()!=null)
		{
			oldTodo.setDescription(todo.getDescription());
		}
		if(todo.getStatus()!=null)
		{
			oldTodo.setStatus(todo.getStatus());
		}
		if(todo.getTaskDate()!=null)
		{
			oldTodo.setTaskDate(todo.getTaskDate());
		}
		
		return todoRepo.save(oldTodo);
	}
}
