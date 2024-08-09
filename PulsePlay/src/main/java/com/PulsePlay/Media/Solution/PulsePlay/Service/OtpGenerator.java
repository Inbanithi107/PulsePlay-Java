package com.PulsePlay.Media.Solution.PulsePlay.Service;

import org.springframework.stereotype.Service;

import io.netty.util.internal.ThreadLocalRandom;

@Service
public class OtpGenerator {
	
	
	public int generateotp() {
		
		int otp=ThreadLocalRandom.current().nextInt(100000, 1000000);
		
		return otp;
		
	}

}
