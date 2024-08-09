package com.PulsePlay.Media.Solution.PulsePlay.Controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;


import com.PulsePlay.Media.Solution.PulsePlay.Service.EmailService;
import com.PulsePlay.Media.Solution.PulsePlay.Service.OtpGenerator;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService service;
	
	@Autowired
	private OtpGenerator otpgenerator;
	
	private int otpcomp;
	
	private String email;
	
	
	public void sendemail(String name, String email) {
		
		try {
		
		Map<String, Object> model=new HashMap<>();
		model.put("Name", name);
		
		int otpcomp=otpgenerator.generateotp();
		setOtpcomp(otpcomp);
		setEmail(email);
		model.put("otp", otpcomp);
		service.sendemail(model, email);
		
		
		
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}


	public int getOtpcomp() {
		return otpcomp;
	}


	public void setOtpcomp(int otpcomp) {
		this.otpcomp = otpcomp;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	
	

}
