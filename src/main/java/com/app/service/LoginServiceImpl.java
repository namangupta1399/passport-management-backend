package com.app.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.User;
import com.app.beans.UserCredentials;
import com.app.exception.PasswordInvalidException;
import com.app.exception.UserRoleInvalidException;
import com.app.validation.UserValidation;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserValidation userValidation;
	
	/**
	 * The method is used to verify login info with the DB
	 * @param UserCredentials - email, id, password
	 * @return User - returns user if user info is valid
	 * @throws UserRoleInvalidException
	 * @throws PasswordInvalidException
	 */
	public User loginUser(UserCredentials credentials) {
		logger.info("loginUser() called");
		userValidation.validateLogin(credentials);
		
		User user = userService.getUserByEmail(credentials.getEmail());
		
		if(!credentials.getUserRole().equals(user.getuserRole())) {
			throw new UserRoleInvalidException("User role is invalid!");
		}
		if(!credentials.getPassword().equals(user.getPassword())) {
			throw new PasswordInvalidException("Password does not match!");
		}
		return user;
		
	}

}
