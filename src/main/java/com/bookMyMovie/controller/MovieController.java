package com.bookMyMovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookMyMovie.model.Movie;
import com.bookMyMovie.services.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	/**
	 * Returns list of movies.
	 * 
	 * @return List of Movie objects.
	 */
	@GetMapping("/movies")
	List<Movie> getMovies() {
		List<Movie> movies = movieService.getMovies();
		return movies;
	}

	/**
	 * Returns movie object for the given movie id.
	 * 
	 * @param movieId
	 * @return Movie object.
	 */
	@GetMapping("/movies/{movieId}")
	Movie getMovieDescription(@PathVariable("movieId") String movieId) {
		return movieService.getMovieDescription(movieId);
	}

}
