package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.beans.User;
import com.app.repository.PassportApplicationRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class ApplicantServiceImpl implements IApplicantService{
	
	Logger logger = LoggerFactory.getLogger(ApplicantServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PassportApplicationRepository applicationRepository;
	

	

	public User addUser(User user) {
		
		logger.info("addUser() called");
		
		return userRepository.save(user);
		
	}

	
	public void deleteUser(int userId) {
		
		logger.info("deleteUser() called");
		
		userRepository.deleteById(userId);
	}

	
	public void updateUser(int userId, User user) {
		
		logger.info("updateUser() called");
		
		userRepository.save(user);
		
	}

	
	public User viewUser(int userId) {
		
		logger.info("viewUser() called");
		
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

}
