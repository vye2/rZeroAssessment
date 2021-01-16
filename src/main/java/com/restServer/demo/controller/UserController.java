package com.restServer.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restServer.demo.model.User;
import com.restServer.demo.service.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public List<User> getUsers() {
		return this.userService.getUsers();
	}

//	@GetMapping(path="/{id}")
//	public Optional<User> getUser(@PathVariable("id") int id) {
//		return repository.findById(id);
//	}
	
	@PostMapping(path="/add", consumes= {"application/json"}, produces= {"application/json"})
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@DeleteMapping(path="/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {
		return this.userService.removeUser(id);
	}
	
}

