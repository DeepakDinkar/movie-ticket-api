package com.bookMyMovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookMyMovie.model.Review;
import com.bookMyMovie.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	/**
	 * Returns list of reviews given by movie id.
	 *
	 * @param movieId
	 * @return List of review objects.
	 */
	public List<Review> getReviewsListByMovie(String movieId) {
		return reviewRepository.findReviewByMovieId(movieId);
	}
	
	/**
	 * Returns list of reviews.
	 * 
	 * @return List of review objects.
	 */
	public List<Review> getReviewsList() {
		return reviewRepository.findAll();
	}
}
