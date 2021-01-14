package com.restServer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restServer.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
