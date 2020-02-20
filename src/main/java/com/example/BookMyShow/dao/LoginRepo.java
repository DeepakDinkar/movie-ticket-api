package com.example.BookMyShow.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.BookMyShow.model.LoginCredentials;
import com.example.BookMyShow.model.Movie;


public interface LoginRepo extends CrudRepository<LoginCredentials, String>{

	
}
