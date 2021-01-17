package com.restServer.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restServer.demo.model.User;
import com.restServer.demo.service.UserService;
import com.restServer.demo.service.VerifyService;

@RestController
@RequestMapping(path="/users")
public class UserController {
		
	@Autowired
	private UserService userService;
		
	@Autowired
	private VerifyService verifyService;
   
	@GetMapping(produces= {"application/json"})
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}
	
	@PostMapping(path="/add", consumes= {"application/json"}, produces= {"application/json"})
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/remove/{id}", produces= {"application/json"})
	public ResponseEntity<String> removeUser(@PathVariable("id") int id) {
		String removedResult = userService.removeUser(id);
		if (removedResult == null) {
			return new ResponseEntity<>("\"No User with ID " + id + " exists.\"" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("\"Removed " + removedResult + ".\"", HttpStatus.OK);
	}
	
	@GetMapping(path="/verify/{id}", produces= {"application/json"})
	public ResponseEntity<String> getUserVerify(@PathVariable("id") int id) {
		Boolean verifiedResult = verifyService.verifyUser(id);
		if (verifiedResult == null) {
			return new ResponseEntity<>("\"No User with ID " + id + " exists.\"" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("\"User "+ id + " " + verifiedResult + ".\"", HttpStatus.OK);
	}

	
}

