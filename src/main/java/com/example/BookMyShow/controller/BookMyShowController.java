package com.example.BookMyShow.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.model.MovieReview;
import com.example.BookMyShow.services.BookMyShowService;

@RestController
@RequestMapping("/bookmyshow")
public class BookMyShowController {

	@Autowired
	private BookMyShowService bookMyShowService;
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	public Iterable<Movie> getMovies() {
		return bookMyShowService.getMovies();
	}
	
	@RequestMapping(value="/avatar/{movie}", method=RequestMethod.GET, produces="application/json")
	public byte[] getMovieAvatar(@PathVariable String movie) throws SQLException, IOException {
		return bookMyShowService.getMovieAvatar(movie);
	}
	
	@RequestMapping(value="/description/{movie}", method=RequestMethod.GET, produces="application/json")
	public String getMovieDescription(@PathVariable String movie) throws SQLException {
		return bookMyShowService.getMovieDescription(movie);
	}
	
	@RequestMapping(value="/review/{movieId}", method=RequestMethod.GET, produces="application/json")
	public List<MovieReview> getMovieReviews(@PathVariable Integer movieId) throws SQLException {
		return bookMyShowService.getMovieReviews(movieId);
	}
	
	@RequestMapping(value="/theatres", method=RequestMethod.GET, produces="application/json")
	public Map<Integer, String> getThreatres() throws SQLException {
		return bookMyShowService.getTheatres();
	}
	
}
