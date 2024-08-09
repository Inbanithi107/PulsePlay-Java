package com.PulsePlay.Media.Solution.PulsePlay.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.UserData;
import com.PulsePlay.Media.Solution.PulsePlay.Repository.UserVerifyRepository;


@Service
public class UserVerifyService {
	
	@Autowired
	private UserVerifyRepository repository;
	
	public UserData verifyuser(String username) {
		
		UserData user=new UserData();
		user=repository.findByUsername(username);
		
		return user;
	}

}
