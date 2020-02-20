package com.example.BookMyShow.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	Integer movieId;
	String movieName;
	String movieDescription;
	Blob image;

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	
	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", movieDescription=" + movieDescription + ", movieId=" + movieId
				+ "]";
	}
	
	
}
