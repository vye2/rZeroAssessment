package com.restServer.demo.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private int id;
	private String name;
	private Boolean verified;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Optional<Boolean> getVerified() {
		return Optional.ofNullable(verified);
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	

}
