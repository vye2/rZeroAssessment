package com.restServer.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restServer.demo.model.User;
import com.restServer.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	
	@PostMapping("users/add")
	public User addUser(@RequestBody User user) {
		repository.save(user);
		return user;
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return repository.findAll();
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable("id") int id) {
		return repository.findById(id);
	}
}
