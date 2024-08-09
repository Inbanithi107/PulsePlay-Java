package com.PulsePlay.Media.Solution.PulsePlay.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.VideoData;
import com.PulsePlay.Media.Solution.PulsePlay.Repository.VideoDataDownloadRepository;

@Service
public class VideoDataDownloadService {
	
	@Autowired
	private VideoDataDownloadRepository repository;
	
	
	public Optional<VideoData> videodatadownload(long id) {
		Optional<VideoData> data=repository.findById(id);
		return data;
	}

}
