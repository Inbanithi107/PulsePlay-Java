package com.PulsePlay.Media.Solution.PulsePlay.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.VideoData;
import com.PulsePlay.Media.Solution.PulsePlay.Repository.VideoDataRepository;

@Service
public class VideoDataService {
	
	@Autowired
	private VideoDataRepository repository;
	
	public String videodataupload(VideoData videodata) {
		repository.save(videodata);
		
		return "file uploaded succesfully";
	}

}
