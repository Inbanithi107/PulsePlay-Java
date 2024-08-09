package com.PulsePlay.Media.Solution.PulsePlay.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "videodata")
public class VideoData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "moviename")
	private String MovieName;
	
	@Column(name = "moviecast")
	private String MovieCast;
	
	@Column(name = "likes")
	private int likes;
	
	@Column(name = "movieyear")
	private String MovieYear;
	
	@Column(name = "filepath")
	private String MoviePath;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return MovieName;
	}

	public void setMovieName(String movieName) {
		MovieName = movieName;
	}

	public String getMovieCast() {
		return MovieCast;
	}

	public void setMovieCast(String movieCast) {
		MovieCast = movieCast;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getMovieYear() {
		return MovieYear;
	}

	public void setMovieYear(String movieYear) {
		MovieYear = movieYear;
	}

	public String getMoviePath() {
		return MoviePath;
	}

	public void setMoviePath(String moviePath) {
		MoviePath = moviePath;
	}
	
	

}
