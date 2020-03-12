package com.bookMyMovie.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookMyMovie.model.Theatre;

@Repository
public interface TheatreRepository extends MongoRepository<Theatre, String> {
	
	@Query("{'movieIds': { $in: ?0}}")
	List<Theatre> findTheatreByMovieIds(List<String> movieIds);
	
	Theatre findTheatreByTheatreId(String theatreId);
	
}
