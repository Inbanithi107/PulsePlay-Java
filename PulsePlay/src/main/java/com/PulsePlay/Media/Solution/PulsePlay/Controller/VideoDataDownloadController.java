package com.PulsePlay.Media.Solution.PulsePlay.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.VideoData;
import com.PulsePlay.Media.Solution.PulsePlay.Service.VideoDataDownloadService;

@RestController
public class VideoDataDownloadController {
	
	@Autowired
	private VideoDataDownloadService service;
	
	public String downloadfilepath(long id) {
		Optional<VideoData> videodata=service.videodatadownload(id);
		String videofilepath=videodata.get().getMoviePath();
		if(videofilepath!=null) {
			return videofilepath;
		}else {
			return "some error had occured";
		}
	}

}
