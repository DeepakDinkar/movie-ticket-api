package com.bookMyMovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookMyMovie.model.ShowTime;
import com.bookMyMovie.repository.ShowTimeRepository;

@Service
public class ShowTimeService {

	@Autowired
	ShowTimeRepository showTimeRepository;

	/**
	 * Returns list of show time.
	 * 
	 * @param theatreId
	 * @return List of ShowTime objects.
	 */
	public List<ShowTime> getShowTimeByTheatreId(String theatreId) {
		return showTimeRepository.findByTheatreId(theatreId);
	}

	/**
	 * Returns list of show time.
	 * 
	 * @param movieId
	 * @return List of ShowTime objects.
	 */
	public List<ShowTime> getShowTimeByMovieId(String movieId) {
		return showTimeRepository.findByMovieId(movieId);
	}

	/**
	 * Returns list of show time.
	 * 
	 * @param theatreId
	 * @param movieId
	 * @return List of ShowTime objects.
	 */
	public List<ShowTime> getShowTimeByTheatreIdAndMovieId(String theatreId, String movieId) {
		return showTimeRepository.findByTheatreIdAndMovieId(theatreId, movieId);
	}

}
