package com.PulsePlay.Media.Solution.PulsePlay.Controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.VideoData;
import com.PulsePlay.Media.Solution.PulsePlay.Service.VideoDataService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class VideoDataController {
	
	@Autowired
	private VideoDataService service;
	
	@PostMapping("/upload")
	public ResponseEntity<String> fileupload(HttpServletRequest request, @RequestParam("file") MultipartFile file){
		
		String moviename=request.getParameter("moviename");
		String moviecast=request.getParameter("moviecast");
		String movieyear=request.getParameter("movieyear");
		
		
		VideoData videodata=new VideoData();
		videodata.setMovieName(moviename);
		videodata.setMovieCast(moviecast);
		videodata.setMovieYear(movieyear);
		videodata.setLikes(0);
		
		
		try {
			String uploadDir="E:\\VideoDatabase";
			
			File uploadpath=new File(uploadDir);
			
			if(!uploadpath.exists()) {
				uploadpath.mkdirs();
			}
			
			String filename=file.getOriginalFilename();
			File dest=new File(uploadpath.getAbsolutePath()+File.separator+filename);
			file.transferTo(dest);
			
			videodata.setMoviePath(dest.toString());
			
			service.videodataupload(videodata);
			
			return new ResponseEntity<>("file uploaded succesfully", HttpStatus.OK);
			
		} catch (IOException e) {
			// TODO: handle exception
			
			return new ResponseEntity<>("file not uploaded", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
