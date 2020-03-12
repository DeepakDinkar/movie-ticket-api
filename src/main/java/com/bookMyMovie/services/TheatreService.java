package com.bookMyMovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookMyMovie.model.Theatre;
import com.bookMyMovie.repository.TheatreRepository;

@Service
public class TheatreService {
	
	@Autowired
	TheatreRepository theatreRepository;
	
	/**
	 * Returns list of theaters which matches the given movie id.
	 * 
	 * @param movieIds
	 * @return
	 */
	public List<Theatre> getTheatresListByMovieId(List<String> movieIds) {
		return theatreRepository.findTheatreByMovieIds(movieIds);
	}
	
	/**
	 * Returns list of theaters which matches the given theater id.
	 * 
	 * @param theatreId
	 * @return
	 */
	public Theatre getTheatreByTheatreId(String theatreId) {
		return theatreRepository.findTheatreByTheatreId(theatreId);
	}
	
	/**
	 * List of theaters.
	 * @return List of theaters.
	 */
	public List<Theatre> getTheatresList() {
		return theatreRepository.findAll();
	}

}
