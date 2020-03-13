package com.example.BookMyShow.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.BookMyShow.model.LoginCredentials;

public interface LoginRepo extends CrudRepository<LoginCredentials, String> {

}
