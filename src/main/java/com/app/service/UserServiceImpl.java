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
	
	/**
	 * The method is used to insert a new user in the DB
	 * @param user. Takes in user object to be inserted into DB
	 * @return the user inserted into DB
	 * @throws UserAlreadyExistException
	 */
	public User addUser(User user) {

		logger.info("addUser() called"); 
		
		if(userRepository.findByEmail(user.getEmail()) != null) {
			throw new UserAlreadyExistException("User already exists!");
		}
		
		userValidation.validateUserFields(user);
		return userRepository.save(user);
	}

	/**
	 * The method is used to delete a user from the DB
	 * @param userId. Takes in user id of user to be deleted
	 * @return nothing
	 * @throws UserNotFoundException
	 */
	public void deleteUser(int userId) {
		logger.info("deleteUser() called"); 
		
		if(getUser(userId) != null) {			
			userRepository.deleteById(userId);
			return;
		}
		throw new UserNotFoundException("User not found!");
	}

	/**
	 * The method is used to update a user in the DB
	 * @param userId. Takes in user id of user to be updated
	 * @param user. Takes user object with the updated details
	 * @return updated user
	 * @throws UserNotFoundException
	 */
	public User updateUser(int userId, User user) {
		logger.info("updateUser() called"); 
		
		if(getUser(userId) == null) {
			throw new UserNotFoundException("User not found!");
		}		
		
		userValidation.validateUserFields(user);
		return userRepository.save(user);
		
	}

	/**
	 * The method is used to get a user from the DB based on id
	 * @param userId
	 * @return user
	 * @throws UserNotFoundException
	 */
	public User getUser(int userId) {
		logger.info("getUser() called");		
		
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found!!");
		}
		return user.get();		
	}
	
	/**
	 * The method is used to get all users from the DB
	 * @param nothing
	 * @return List<User>
	 * @throws UserListEmptyException
	 */
	public List<User> getAllUsers() {
		
		logger.info("getAllUser()called"); 
		
		ArrayList<User> list = new ArrayList<>();
		List<User> userList = userRepository.findAllApplicant();
		if(userList.isEmpty()) {
			throw new UserListEmptyException("No user found");
		}
		for (User user : userList) {
			list.add(user);
		}
		return list;
	}

	/**
	 * The method is used to get a user from DB using email
	 * @param email to get user with this email
	 * @return User
	 * @throws UserNotFoundException
	 */
	@Override
	public User getUserByEmail(String email) {	
		logger.info("getUserByEmail() called");
		User user = userRepository.findByEmail(email);

		if(user != null) {
			return user;
		}
		throw new UserNotFoundException("User does not exist!");
	}
	
}
