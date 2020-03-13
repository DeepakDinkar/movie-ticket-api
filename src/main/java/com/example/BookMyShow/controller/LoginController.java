package com.example.BookMyShow.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookMyShow.model.LoginCredentials;
import com.example.BookMyShow.services.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<?> checkCredentials(@RequestBody LoginCredentials loginDetails) throws SQLException {
		return this.loginService.validateLogin(loginDetails);
	}
}
