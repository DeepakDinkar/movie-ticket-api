package com.bookMyMovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookMyMovie.model.Review;
import com.bookMyMovie.services.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;

	/**
	 * Returns list of reviews given by movie id.
	 *
	 * @param movieId
	 * @return List of Review objects.
	 */
	@GetMapping(path = "/reviews", params = "movieId")
	List<Review> getReviewsListByMovie(@RequestParam("movieId") String movieId) {
		return reviewService.getReviewsListByMovie(movieId);
	}
	
	/**
	 * Returns list of reviews.
	 *
	 * @return List of Review objects.
	 */
	@GetMapping(path = "/reviews")
	List<Review> getReviewsList() {
		return reviewService.getReviewsList();
	}
}
