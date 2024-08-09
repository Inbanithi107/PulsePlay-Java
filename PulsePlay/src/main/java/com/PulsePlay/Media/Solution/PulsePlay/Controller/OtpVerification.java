package com.PulsePlay.Media.Solution.PulsePlay.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.UserData;
import com.PulsePlay.Media.Solution.PulsePlay.Service.UserRegisterService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OtpVerification {
	
	@Autowired
	private EmailController emailcontroller;
	
	@Autowired
	private NewUserRegister userregister;
	
	@Autowired
	private UserRegisterService service;
	
	@PostMapping("/otp-verify")
	public String otpcheck(HttpServletRequest request, Model model) {
		
		String otpuser=request.getParameter("onenumber")+request.getParameter("twonumber")+request.getParameter("threenumber")
		+request.getParameter("fournumber")+
		request.getParameter("fivenumber")+request.getParameter("sixnumber");
		
		int otpcomputer=emailcontroller.getOtpcomp();
		
		String otpgenerated=String.valueOf(otpcomputer);
		
		if(otpuser.equals(otpgenerated)) {
			
			UserData userdata=new UserData();
			
			userdata.setUsername(userregister.getUsername());
			userdata.setPassword(userregister.getPassword());
			userdata.setEmail(userregister.getEmail());
			userdata.setMobile(userregister.getMobileno());
			
			service.saveuser(userdata);
			
			return "home";
		} else {
			String email=emailcontroller.getEmail();
			model.addAttribute("email", email);
			return "otp-verification";
		}
	}

}
