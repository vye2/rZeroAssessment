package com.restServer.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restServer.demo.model.User;
import com.restServer.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User addUser(User user) {
		repository.save(user);
		return user;
	}
	
	public List<User> getUsers() {
		return repository.findAll();
	}
	
	public Boolean removeUser(int id) {
		if (!repository.existsById(id)) {
			return false;
		}
		repository.deleteById(id);
		return true;
	}
}
