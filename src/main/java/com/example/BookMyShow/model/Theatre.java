package com.example.BookMyShow.model;

public class Theatre {

	String theatreName;
	Integer theatreId;
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public Integer getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}
	@Override
	public String toString() {
		return "Theatre [theatreName=" + theatreName + ", theatreId=" + theatreId + "]";
	}
	
	
}
