package com.bookMyMovie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookMyMovie.model.Movie;

@Repository
public interface MovieRespository extends MongoRepository<Movie, String> {

	Movie findMovieByMovieId(String movieId);
}
