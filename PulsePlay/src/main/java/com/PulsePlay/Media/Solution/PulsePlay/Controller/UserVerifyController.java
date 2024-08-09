package com.PulsePlay.Media.Solution.PulsePlay.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.UserData;
import com.PulsePlay.Media.Solution.PulsePlay.Service.UserVerifyService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserVerifyController {
	
	private String username;
	
	@Autowired
	private UserVerifyService service;
	
	@PostMapping("/login")
	public String checkuser(HttpServletRequest request, Model model) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserData data=new UserData();
		
		data=service.verifyuser(username);
		if(data!=null) {
			if(data.getUsername().equals(username) && data.getPassword().equals(password)) {
				setUsername(username);
				return "pulseplay-movies";
			}else {
				model.addAttribute("pass", "please check your username and password");
			}
		}else {
			model.addAttribute("notfound", "User not found");
		}
		
		return "sign-in";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
