package com.todo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todo.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	User findById(int id);
}
