package com.restServer.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restServer.demo.model.User;
import com.restServer.demo.repository.UserRepository;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	
	//Automatically inject UserRepository dependency.
	@Autowired
	UserRepository repository;
	
	
	@GetMapping
	public List<User> getUsers() {
		return repository.findAll();
	}

//	@GetMapping(path="/{id}")
//	public Optional<User> getUser(@PathVariable("id") int id) {
//		return repository.findById(id);
//	}
	
	@PostMapping(path="/add", consumes= {"application/json"}, produces= {"application/json"})
	public User addUser(@RequestBody User user) {
		repository.save(user);
		return user;
	}
	
	@DeleteMapping(path="/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {
		User userToRemove = repository.getOne(id);
		repository.delete(userToRemove);
		return "Deleted User with ID " +  id;
	}
	
}

