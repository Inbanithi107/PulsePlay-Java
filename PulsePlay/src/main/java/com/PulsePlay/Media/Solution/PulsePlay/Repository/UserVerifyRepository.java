package com.PulsePlay.Media.Solution.PulsePlay.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.UserData;


public interface UserVerifyRepository extends JpaRepository<UserData, Long> {
	
	UserData findByUsername(String username);

}
