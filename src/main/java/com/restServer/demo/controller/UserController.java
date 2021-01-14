package com.restServer.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.restServer.demo.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository repository;

}
