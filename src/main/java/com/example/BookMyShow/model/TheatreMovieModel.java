package com.example.BookMyShow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TheatreMovieModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	Integer theatreId;
	Integer movieId;
	String theatre;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getTheatre() {
		return theatre;
	}
	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}
	
	@Override
	public String toString() {
		return "TheatreMovieModel [id=" + id + ", theatreId=" + theatreId + ", movieId=" + movieId + ", theatre="
				+ theatre + "]";
	}
	
	
	
}
