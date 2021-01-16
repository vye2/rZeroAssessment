package com.restServer.demo.component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restServer.demo.model.User;
import com.restServer.demo.service.UserService;

@Component
public class ApplicationStartupRunner implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
		
	@Override
	public void run(String... args) {
		ObjectMapper mapper = new ObjectMapper();		
		TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
		try {
			List<User> users = mapper.readValue(inputStream, typeReference);
			for (User user: users) {
				userService.addUser(user);
			}
			System.out.println("Saved " + users.size() + " initial users.");
			
		} catch (IOException e) {
			System.out.println("Unable to save users: " + e.getMessage());
		}
	}
}
