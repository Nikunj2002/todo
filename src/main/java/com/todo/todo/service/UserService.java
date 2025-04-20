package com.todo.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todo.model.User;
import com.todo.todo.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	public User createUser(User requestUser) {
		return userRepo.save(requestUser);
	}
}
