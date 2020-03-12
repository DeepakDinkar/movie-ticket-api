package com.bookMyMovie.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Theatre")
public class Theatre {

	@Id
	private String id;

	private String theatreId;
	private String theatreName;
	private List<String> movieIds;
	private List<String> showTime;

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public List<String> getMovieIds() {
		return movieIds;
	}

	public void setMovieIds(List<String> movieIds) {
		this.movieIds = movieIds;
	}

	public List<String> getShowTime() {
		return showTime;
	}

	public void setShowTime(List<String> showTime) {
		this.showTime = showTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", movieIds=" + movieIds
				+ ", showTime=" + showTime + "]";
	}

}
