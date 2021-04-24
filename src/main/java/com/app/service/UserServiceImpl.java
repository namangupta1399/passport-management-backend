package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.User;
import com.app.exception.UserAlreadyExistException;
import com.app.exception.UserNotFoundException;
import com.app.repository.UserRepository;
import com.app.validation.UserValidation;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserValidation userValidation;
	
	public User addUser(User user) {

		logger.info("addUser() called"); 
		
		if(userRepository.findByEmail(user.getEmail()) != null) {
			throw new UserAlreadyExistException("User already exists!");
		}
		
		userValidation.validateUserFields(user);
		return userRepository.save(user);
	}

	
	public void deleteUser(int userId) {
		logger.info("deleteUser() called"); 
		
		if(getUser(userId) != null) {			
			userRepository.deleteById(userId);
			return;
		}
		throw new UserNotFoundException("User not found!");
	}

	
	public User updateUser(int userId, User user) {
		logger.info("updateUser() called"); 
		
		if(getUser(userId) == null) {
			throw new UserNotFoundException("User not found!");
		}		
		
		userValidation.validateUserFields(user);
		return userRepository.save(user);
		
	}

	
	public User getUser(int userId) {
		logger.info("viewUser() called");		
		
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found!!");
		}
		return user.get();		
	}
	
	@Override
	public List<User> getAllUsers() {
		
		logger.info("getAllUser()called"); 
		
		ArrayList<User> list = new ArrayList<>();
		Collection<User> userList = userRepository.findAllApplicant();
		for (User user : userList) {
			list.add(user);
		}
		return list;
	}
	
}
