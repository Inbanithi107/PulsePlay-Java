package com.PulsePlay.Media.Solution.PulsePlay.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class VideoStreamingController {
	
	@Autowired
	private ResourceLoader resourceloader;
	
	@Autowired
	private VideoDataDownloadController downloadcontroller;
	
	@GetMapping(value = "/video/streaming/{id}", produces = "video/mp4")
	private Mono<Resource> getvideo(@PathVariable long id) {
		
		final String FORMAT="file:"+downloadcontroller.downloadfilepath(id);
		
		return Mono.fromSupplier(()->resourceloader.getResource(FORMAT));
		
	}

}
