package com.restServer.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restServer.demo.model.User;
import com.restServer.demo.repository.UserRepository;

@Service
public class VerifyService {

	@Autowired
	private UserRepository repository;
	
    private boolean verification() {
    	try
    	{
    	    Thread.sleep(2000);
    	}
    	catch(InterruptedException ex)
    	{
    	    Thread.currentThread().interrupt();
    	}        
    	return Math.random() < 0.5;
    }

    
	public boolean verifyUser(int id) {
		Optional<User> selectedUser = repository.findById(id);
		if (selectedUser.isEmpty()) {
			return false;
		}
		
		System.out.println("SELECTED USER: " +  selectedUser);

		User user = selectedUser.get();
		
		Optional<Boolean> verifiedBool = user.getVerified();
		
		boolean firstTime = true;
		
		if (verifiedBool.isPresent()) {
			firstTime = false;
		}
		
		if (firstTime) {
			boolean flagToSet = verification();
			System.out.println("FLAGTOSET: " + flagToSet);

			user.setVerified(flagToSet);
			repository.save(user);
		}
		return user.getVerified().get();
		

	}
    
    
}
