package com.example.BookMyShow.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.BookMyShow.model.Movie;

public interface MoviesRepo extends CrudRepository<Movie, Integer> {

}
