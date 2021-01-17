package com.restServer.demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restServer.demo.model.User;
import com.restServer.demo.service.UserService;

@Configuration
public class PreloadDatabase {
	@Bean
	CommandLineRunner preloadDB(UserService userService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();		
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try {
				List<User> users = mapper.readValue(inputStream, typeReference);
				System.out.println("USERS: " + users);
				for (User user: users) {
					userService.addUser(user);
				}
				System.out.println("Saved " + users.size() + " initial users.");
				
			} catch (IOException e) {
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
}
