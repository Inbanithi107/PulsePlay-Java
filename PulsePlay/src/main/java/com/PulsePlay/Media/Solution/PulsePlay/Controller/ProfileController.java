package com.PulsePlay.Media.Solution.PulsePlay.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.PulsePlay.Media.Solution.PulsePlay.Entity.UserData;
import com.PulsePlay.Media.Solution.PulsePlay.Service.ProfileService;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@Autowired
	private UserVerifyController verify;
	
	@GetMapping("/profile")
	public String settingprofile(Model mov) {
		UserData data=new UserData();
		data=service.profilesetter(verify.getUsername());
		if(data!=null) {
			
			mov.addAttribute("name", data.getUsername());
			mov.addAttribute("phone", data.getMobile());
			mov.addAttribute("email", data.getEmail());
			return "profile";
		}
		
		return "could not fetch details";
	}

}
