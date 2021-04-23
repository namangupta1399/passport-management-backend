package com.app.validation;

import org.springframework.stereotype.Component;

import com.app.beans.User;

@Component
public class UserValidation {
	public boolean validateUserFields(User user) {
		if(!validateEmail(user.getEmail())) {
			throw new RuntimeException("email is invalid");
		}
		return true;
	}
	
	private boolean validatePassword(String password) {
		return false;
	}
	
	private boolean validateEmail(String email) {
		return email.contains("@");
	}
}
