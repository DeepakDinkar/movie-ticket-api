package com.example.BookMyShow.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccessCredentials {
	@Id
	String username;
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AccessCredentials [username=" + username + ", password=" + password + "]";
	}
	
}
