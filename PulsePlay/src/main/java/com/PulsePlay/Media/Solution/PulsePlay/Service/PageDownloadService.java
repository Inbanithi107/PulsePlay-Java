package com.PulsePlay.Media.Solution.PulsePlay.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PulsePlay.Media.Solution.PulsePlay.Entity.VideoData;
import com.PulsePlay.Media.Solution.PulsePlay.Repository.VideoDataDownloadRepository;

@Service
public class PageDownloadService {
	
	@Autowired
	private VideoDataDownloadRepository repo;
	
	public Map<String, Object> getpagedetails(Long id) {
		
		Optional<VideoData> data=repo.findById(id);
		long idl=data.get().getId();
		String idls=Long.toString(idl);
		Map<String, Object> setter=new HashMap<>();
		if(idls!=null) {
			setter.put("cast", data.get().getMovieCast());
			setter.put("name", data.get().getMovieName());
			setter.put("year", data.get().getMovieYear());
			setter.put("like", data.get().getLikes());
			return setter;
		}else {
			return setter;
		}
		
	}

}
