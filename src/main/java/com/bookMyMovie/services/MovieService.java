package com.bookMyMovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookMyMovie.model.Movie;
import com.bookMyMovie.repository.MovieRespository;

@Service
public class MovieService {

	@Autowired
	MovieRespository movieRespository;

	/**
	 * Returns list of movies.
	 *
	 * @return List of Movie objects.
	 */
	public List<Movie> getMovies() {
		return movieRespository.findAll();
	}

	/**
	 * Returns movie object for the given movie id.
	 *
	 * @param movieId
	 * @return Movie object.
	 */
	public Movie getMovieDescription(String movieId) {
		return movieRespository.findMovieByMovieId(movieId);
	}
}
