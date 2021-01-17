package com.restServer.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restServer.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
