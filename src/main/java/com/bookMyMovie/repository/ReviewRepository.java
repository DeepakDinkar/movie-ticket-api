package com.bookMyMovie.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookMyMovie.model.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {

	List<Review> findReviewByMovieId(String movieId);
}
