package com.bookMyMovie.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookMyMovie.model.Theatre;
import com.bookMyMovie.services.TheatreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags = { "Theatres" }, value = "Theatres")
@SwaggerDefinition(tags = { @Tag(name = "Theatres", description = "Get the information about theatres") })
@RestController
public class ThreatreController {

	@Autowired
	TheatreService theatreService;

	/**
	 * Returns list of theaters which matches the given theater id.
	 * 
	 * @param theatreId
	 * @return List of Theater objects.
	 */
	@GetMapping(path = "/theatre", params = "theatreId")
	Theatre getTheatresListByTheatreId(@RequestParam("theatreId") String theatreId) {
		return theatreService.getTheatreByTheatreId(theatreId);
	}
	
	/**
	 * Returns list of theaters which matches the given movie id.
	 * 
	 * @param movieId
	 * @return List of Theater objects.
	 */
	@GetMapping(path = "/theatre", params = "movieId")
	List<Theatre> getTheatresListByMovieId(@RequestParam("movieId") String movieId) {
		List<String> list = Arrays.asList(movieId);
		return theatreService.getTheatresListByMovieId(list);
	}

	

	/**
	 * Returns list of theaters.
	 *
	 * @return List of Theater objects.
	 */
	@GetMapping(path = "/theatres")
	List<Theatre> getTheatresList() {
		return theatreService.getTheatresList();
	}
}
