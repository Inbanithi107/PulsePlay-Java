package com.PulsePlay.Media.Solution.PulsePlay.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.UserData;
import com.PulsePlay.Media.Solution.PulsePlay.Repository.UserVerifyRepository;

@Service
public class ProfileService {
	
	@Autowired
	private UserVerifyRepository repo;
	
	public UserData profilesetter(String username) {
		return repo.findByUsername(username);
	}

}
