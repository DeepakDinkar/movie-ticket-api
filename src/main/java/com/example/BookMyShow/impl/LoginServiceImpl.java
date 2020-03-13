package com.example.BookMyShow.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.BookMyShow.model.LoginCredentials;
import com.example.BookMyShow.model.LoginResult;

@Component
public class LoginServiceImpl {

	static final String JDBC_DRIVER = "org.h2.Driver"; // org.h2.Driver
	static final String DB_URL = "jdbc:h2:mem:danny";
	static final String USER = "sa";
	static final String PASS = "";
	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	Statement stmt = conn.createStatement();

	public LoginServiceImpl() throws SQLException {
		super();
	}

	public ResponseEntity<?> validateLogin(LoginCredentials logindetails) throws SQLException {
		String username = logindetails.getUsername();
		String sqlQuery = "select password from login_credentials where (username=?)";
		PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
		prepStmt.setString(1, username);
		ResultSet result = prepStmt.executeQuery();
		LoginResult response = new LoginResult();
		if (result.next()) {
			String password = result.getString("password");
			if (password.compareTo(logindetails.getPassword()) == 0) {
				// Login success
				response.setSuccess(true);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				// Invalid password
				int unauthorized = 401;
				response.setMessage("Invalid credentials");
				return new ResponseEntity<>(response, HttpStatus.valueOf(unauthorized));
			}
		} else {
			System.out.println("invalid username");
			response.setSuccess(false);
			response.setMessage("User not configured");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

}
