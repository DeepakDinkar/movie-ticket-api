package com.bookMyMovie.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ShowTime")
public class ShowTime {

	@Id
	private String id;

	private String showTimeId;
	private String movieId;
	private String theatreId;
	private String showTime;
	private Set<String> seats = new HashSet<>();

	public Set<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats.addAll(seats);
	}

	public String getShowTimeId() {
		return showTimeId;
	}

	public void setShowTimeId(String showTimeId) {
		this.showTimeId = showTimeId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSeats(Set<String> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "ShowTime [showTimeId=" + showTimeId + ", movieId=" + movieId + ", theatreId=" + theatreId
				+ ", showTime=" + showTime + "]";
	}

}
