package com.example.BookMyShow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer reviewId;
	Integer movieId;
	String reviewerName;
	String Review;
	Double rating;
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "MovieReview [reviewId=" + reviewId + ", movieId=" + movieId + ", reviewerName=" + reviewerName
				+ ", Review=" + Review + ", rating=" + rating + "]";
	}

	
	
	
}
