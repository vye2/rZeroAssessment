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
	
    private boolean sampleVerification() {
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
    
	public Boolean verifyUser(int id) {
		Optional<User> selectedUser = repository.findById(id);
		
		//If User doesn't exist, then no data to return. Else get the user.
		if (selectedUser.isEmpty()) 
			return null;
		User user = selectedUser.get();
		
		//Check if the verification service has been called before for this user.
		Optional<Boolean> userVerifiedBool = user.getVerified();
		
		//If first time called, save verification result.
		if (userVerifiedBool.isEmpty()) {
			boolean flagToSet = sampleVerification();
			user.setVerified(flagToSet);
			repository.save(user);
		}
		
		return user.getVerified().get();
		
	}
    
    
}
