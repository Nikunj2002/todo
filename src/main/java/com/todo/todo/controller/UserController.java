package com.todo.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.model.User;
import com.todo.todo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	@PostMapping("/create-user")
	public User createUser(@RequestBody User requestUser) {
		return userService.createUser(requestUser);
	}
}
