package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.User;
import com.app.repository.UserRepository;
import com.app.validation.UserValidation;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserValidation userValidation;
	
	public User addUser(User user) {
		userValidation.validateUserFields(user);
		return userRepository.save(user);
	}

	
	public void deleteUser(int userId) {
		
		userRepository.deleteById(userId);
	}

	
	public User updateUser(int userId, User user) {
		return userRepository.save(user);
		
	}

	
	public User viewUser(int userId) {
		User user = userRepository.findById(userId).get();
		user.setPassword(null);
		return user;
		
	}


	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userRepository.deleteById(user.getId());	
	}
	
	@Override
	public List<User> getAllUsers() {
		ArrayList<User> list = new ArrayList<>();
		Collection<User> userList = userRepository.findAll();
		for (User user : userList) {
			user.setPassword(null);
			list.add(user);
		}
		return list;
	}
	
}
