package com.example.BookMyShow.services;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookMyShow.impl.BookMyShowImpl;
import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.model.MovieReview;

@Service
public class BookMyShowService {

	@Autowired
	private BookMyShowImpl bmsImpl;
	
	public Iterable<Movie> getMovies() {
		return bmsImpl.getMovies();
	}
	
	public String getMovieDescription(String movie) throws SQLException {
		return bmsImpl.getMovieDescription(movie);
	}
	
	public byte[] getMovieAvatar(String movie) throws SQLException, IOException {
		return bmsImpl.getMovieAvatar(movie);
	}
	
	public List<MovieReview> getMovieReviews(Integer movieId) throws SQLException {
		return bmsImpl.getMovieReviews(movieId);
	}
	
	public Map<Integer, String> getTheatres() throws SQLException {
		return bmsImpl.getTheatres();
	}
}
