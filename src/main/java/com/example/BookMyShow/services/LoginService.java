package com.example.BookMyShow.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.BookMyShow.impl.LoginServiceImpl;
import com.example.BookMyShow.model.LoginCredentials;
import com.example.BookMyShow.model.LoginResult;

@Service
public class LoginService {

	@Autowired
	private LoginServiceImpl loginImpl;
	
	public ResponseEntity<?> validateLogin(LoginCredentials logindetails) throws SQLException {
		return this.loginImpl.validateLogin(logindetails);
	}
}
