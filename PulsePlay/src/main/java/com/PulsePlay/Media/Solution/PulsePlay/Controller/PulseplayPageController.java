package com.PulsePlay.Media.Solution.PulsePlay.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PulseplayPageController {
	
	@GetMapping("/stream")
	public String streamingpage() {
		return "streamingpage";
	}
	
    
    @GetMapping("/home")
    public String home() {
    	return "home";
    }
    
    @GetMapping("/sign-in")
    public String signin() {
    	return "sign-in";
    }
    
    @GetMapping("/sign-up")
    public String register() {
    	return "user-register";
    }

}
