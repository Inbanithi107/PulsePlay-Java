package com.PulsePlay.Media.Solution.PulsePlay.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PulsePlay.Media.Solution.PulsePlay.Service.PageDownloadService;

@Controller
public class PageSeterController {
	
	@Autowired
	private PageDownloadService service;
	
	@GetMapping("/video/{id}")
	public String everythingworksfine(@PathVariable long id, Model model) {
		
		String idl = "/video/streaming/"+id;
		
		Map<String, Object> details=service.getpagedetails(id);
		
		model.addAttribute("ids", idl);
		model.addAttribute("name", details.get("name"));
		model.addAttribute("cast", details.get("cast"));
		model.addAttribute("year", details.get("year"));
		model.addAttribute("likes", details.get("like"));
		
		return "videoplayer";
		
	}

}
