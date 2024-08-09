package com.PulsePlay.Media.Solution.PulsePlay.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.UserData;
import com.PulsePlay.Media.Solution.PulsePlay.Repository.UserRegisterRepository;

@Service
public class UserRegisterService {
	
	@Autowired
	private UserRegisterRepository repo;
	
	public void saveuser(UserData data) {
		repo.save(data);
	}

}
