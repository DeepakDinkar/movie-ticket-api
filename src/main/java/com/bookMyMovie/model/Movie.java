package com.bookMyMovie.model;

import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Movie")
public class Movie {

	@Id
	private String id;

	private String movieId;
	private String movieName;
	private List<Binary> movieImages;
	private List<String> cast;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List<?> getMovieImages() {
		return movieImages;
	}

	public void setMovieImages(List<Binary> movieImages) {
		this.movieImages = movieImages;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	@Override
	public String toString() {
		return "Review [movieId=" + movieId + ", movieName=" + movieName + ", movieImages=" + movieImages + ", cast="
				+ cast + "]";
	}
}
