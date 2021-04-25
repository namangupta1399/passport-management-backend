package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.app.beans.User;
import com.app.beans.UserCredentials;
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
	
	public boolean validateLogin(UserCredentials user) {
		if(!validateEmail(user.getEmail())) {
			throw new EmailInvalidException("Email is invalid");
		}
		if(!validatePassword(user.getPassword())) {
			throw new PasswordInvalidException("Password is invalid. It must contain atleast a lowercase alphabet, an uppercase alphabet, digit, special character and must be atleast 8 characters long.");
		}
		if(!validateUserRole(user.getUserRole())) {
			throw new UserRoleInvalidException("User role cannot be other than applicant or admin");
		}
		return true;
	}
	
//	Password validation method (Atleast 1 digit, 1 lowercase and 1 uppercase alphabet, 1 special charater and min length 8 chars
	public boolean validatePassword(String password) {
		if(password.isEmpty()) {
			throw new PasswordInvalidException("Password cannot be blank");
		}
		return validatePattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", password);
	}
	
//	Email validation method
	public boolean validateEmail(String email) {
		if(email.isEmpty()) {
			throw new EmailInvalidException("Email cannot be blank");
		}
		return validatePattern("^(.+)@(.+)$", email);
	}
	
//	User role validation
	public boolean validateUserRole(String role) {
		if(role.isEmpty()) {
			throw new UserRoleInvalidException("User role cannot be empty");
		}
		return role.equalsIgnoreCase("applicant") || role.equalsIgnoreCase("admin"); 
	}
}
