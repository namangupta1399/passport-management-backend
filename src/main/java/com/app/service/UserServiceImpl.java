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
import com.app.exception.UserListEmptyException;
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

		String addUser = "addUser()";
		logger.info(addUser + "called"); 
		
		if(userRepository.findByEmail(user.getEmail()) != null) {
			throw new UserAlreadyExistException("User already exists!");
		}
		
		userValidation.validateUserFields(user);
		return userRepository.save(user);
	}

	
	public void deleteUser(int userId) {
		String deleteUser = "deleteUser()";
		logger.info(deleteUser + "called"); 
		
		if(viewUser(userId) != null) {			
			userRepository.deleteById(userId);
			return;
		}
		throw new UserNotFoundException("User not found!");
	}

	
	public User updateUser(int userId, User user) {
		String updateUser = "updateUser()";
		logger.info(updateUser + "called"); 
		
		if(viewUser(userId) == null) {
			throw new UserNotFoundException("User not found!");
		}		
		
		userValidation.validateUserFields(user);
		return userRepository.save(user);
		
	}

	
	public User viewUser(int userId) {
		String viewUser = "viewUser()";
		logger.info(viewUser + "called");		
		
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found!!");
		}
		return user.get();		
	}
	
	@Override
	public List<User> getAllUsers() {
		
		String getAllUser = "getAllUser()";
		logger.info(getAllUser + "called"); 
		
		ArrayList<User> list = new ArrayList<>();
		Collection<User> userList = userRepository.findAllApplicant();
		if(userList.size() <= 0) {
			throw new UserListEmptyException("No user found!");
		}
		for (User user : userList) {
//			user.setPassword(null);
			list.add(user);
		}
		return list;
	}
	
}
