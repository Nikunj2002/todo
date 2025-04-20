package com.todo.todo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String email;
	private String password;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonManagedReference
//	@JoinColumn(name="todoId",referencedColumnName = "todoId")
	private List<Todo> todoList=new ArrayList<>();
}
