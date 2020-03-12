package com.bookMyMovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookMyMovie.model.ShowTime;
import com.bookMyMovie.services.ShowTimeService;

@RestController
public class ShowTimeController {

	@Autowired
	ShowTimeService showTimeService;

	/**
	 * Returns list of show time.
	 * 
	 * @param theatreId
	 * @return List of ShowTime objects.
	 */
	@GetMapping(path = "/shows", params = "theatreId")
	List<ShowTime> getShowTimeByTheatreId(@RequestParam String theatreId) {
		return showTimeService.getShowTimeByTheatreId(theatreId);
	}

	/**
	 * Returns list of show time.
	 * 
	 * @param movieId
	 * @return List of ShowTime objects.
	 */
	@GetMapping(path = "/shows", params = "movieId")
	List<ShowTime> getShowTimeByMovieId(@RequestParam String movieId) {
		return showTimeService.getShowTimeByMovieId(movieId);
	}

	/**
	 * Returns list of show time.
	 * 
	 * @param theatreId
	 * @param movieId
	 * @return List of ShowTime objects.
	 */
	@GetMapping(path = "/shows", params = { "theatreId", "movieId" })
	List<ShowTime> getShowTimeByTheatreIdAndMovieId(@RequestParam String theatreId, @RequestParam String movieId) {
		return showTimeService.getShowTimeByTheatreIdAndMovieId(theatreId, movieId);
	}

}
