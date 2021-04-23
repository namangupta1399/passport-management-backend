package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.app.beans.User;
import com.app.exception.EmailInvalidException;
import com.app.exception.PasswordInvalidException;
import com.app.exception.UserRoleInvalidException;

@Component
public class UserValidation {

//	Pattern check method
	private boolean validatePattern(String regex, String input) {
		return Pattern.matches(regex, input);		
	}
	
//	Validating all the fields in user object
	public boolean validateUserFields(User user) {
		if(!validateEmail(user.getEmail())) {
			throw new EmailInvalidException("Email is invalid");
		}
		if(!validatePassword(user.getPassword())) {
			throw new PasswordInvalidException("Password is invalid. It must contain atleast a lowercase alphabet, an uppercase alphabet, digit, special character and must be atleast 8 characters long.");
		}
		if(!validateUserRole(user.getuserRole())) {
			throw new UserRoleInvalidException("User role cannot be other than applicant or admin");
		}
		return true;
	}
	
//	Password validation method (Atleast 1 digit, 1 lowercase and 1 uppercase alphabet, 1 special charater and min length 8 chars
	private boolean validatePassword(String password) {
		return validatePattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", password);
	}
	
//	Email validation method
	private boolean validateEmail(String email) {
		return validatePattern("^(.+)@(.+)$", email);
	}
	
//	User role validation
	private boolean validateUserRole(String role) {
		return role.toLowerCase().equals("applicant") || role.toLowerCase().equals("admin"); 
	}
}
