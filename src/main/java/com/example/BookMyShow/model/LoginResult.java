package com.example.BookMyShow.model;

public class LoginResult {

	Boolean success;
	String message;
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "LoginResult [success=" + success + ", message=" + message + "]";
	}
	
	
	
	
}
