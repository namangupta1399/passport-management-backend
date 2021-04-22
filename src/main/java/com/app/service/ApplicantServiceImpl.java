package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.beans.User;
import com.app.repository.PassportApplicationRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class ApplicantServiceImpl implements IApplicantService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PassportApplicationRepository applicationRepository;
	

	

	public User addUser(User user) {
		
		return userRepository.save(user);
		
	}

	
	public void deleteUser(int userId) {
		
		userRepository.deleteById(userId);
	}

	
	public void updateUser(int userId, User user) {
		userRepository.save(user);
		
	}

	
	public User viewUser(int userId) {
		return userRepository.findById(userId).get();
		
	}


	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		applicationRepository.deleteById(user.getId());
	}

}
