package com.bookMyMovie.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookMyMovie.model.ShowTime;

public interface ShowTimeRepository extends MongoRepository<ShowTime, String> {

	List<ShowTime> findByTheatreId(String theatreId);

	List<ShowTime> findByMovieId(String movieId);

	List<ShowTime> findByTheatreIdAndMovieId(String theatreId, String movieId);

}
