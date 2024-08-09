package com.PulsePlay.Media.Solution.PulsePlay.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.UserData;

public interface UserRegisterRepository extends JpaRepository<UserData, Long> {

}
