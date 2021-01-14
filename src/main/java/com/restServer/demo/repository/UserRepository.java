package com.restServer.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.restServer.demo.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
