package com.PulsePlay.Media.Solution.PulsePlay.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;



import jakarta.servlet.http.HttpServletRequest;

@Controller
public class NewUserRegister {
	
	private String email;
	
	private String username;
	
	private String password;
	
	private String mobileno;
	
	
	
	@Autowired
	private EmailController emailcon;
	
	
	

	
	
	
	
	@PostMapping("/sign-up")
	public String userregistration(HttpServletRequest request, Model model) {
		
		final String email = request.getParameter("email");
		
		setEmail(email);
		
		model.addAttribute("email", email);
		
		return "user-register";
		
	}
	
	
	
	@PostMapping("/user-register")
	public String userdetail(HttpServletRequest request, Model model) {
		
		String message="please check your password";
		
		
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		String repassword=request.getParameter("re-password");
		String mobile=request.getParameter("phone");
		
		if (pass.equals(repassword)) {
			String password=pass;
			
			setUsername(username);
			setPassword(password);
			setEmail(email);
			setMobileno(mobile);
			
			emailcon.sendemail(username, email);
			model.addAttribute("email", email);
			
			return "otp-verification";
		} else {
			model.addAttribute("error", message);
			model.addAttribute("email", getEmail());
			return "user-register";

		}
		
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMobileno() {
		return mobileno;
	}



	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}



	public EmailController getEmailcon() {
		return emailcon;
	}



	public void setEmailcon(EmailController emailcon) {
		this.emailcon = emailcon;
	}
	
	

}
