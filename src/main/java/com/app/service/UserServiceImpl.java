package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.User;
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
		
		userValidation.validateUserFields(user);
		return userRepository.save(user);
	}

	
	public void deleteUser(int userId) {
		
		String deleteUser = "deleteUser()";
		logger.info(deleteUser + "called"); 
		
		userRepository.deleteById(userId);
	}

	
	public User updateUser(int userId, User user) {
		
		String updateUser = "updateUser()";
		logger.info(updateUser + "called"); 
		
		return userRepository.save(user);
		
	}

	
	public User viewUser(int userId) {
		
		String viewUser = "viewUser()";
		logger.info(viewUser + "called"); 
		
		User user = userRepository.findById(userId).get();
		user.setPassword(null);
		return user;
		
	}


	@Override
	public void deleteUser(User user) {
		
		String dropUser = "deleteUser()";
		logger.info(dropUser + "called"); 
		
		// TODO Auto-generated method stub
		userRepository.deleteById(user.getId());	
	}
	
	@Override
	public List<User> getAllUsers() {
		
		String getAllUser = "getAllUser()";
		logger.info(getAllUser + "called"); 
		
		ArrayList<User> list = new ArrayList<>();
		Collection<User> userList = userRepository.findAll();
		for (User user : userList) {
			user.setPassword(null);
			list.add(user);
		}
		return list;
	}
	
}
