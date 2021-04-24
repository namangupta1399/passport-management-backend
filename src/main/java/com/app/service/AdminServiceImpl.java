package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.beans.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	
	Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	/**
	 *	methodName: getAllUsers()
	 *	return type: List<User>
	 * 	 	
	 */
	@Override
	public List<User> getAllUsers() {
		
		logger.info("getAllUsers() called"); 
		
		ArrayList<User> list = new ArrayList<>();
		Collection<User> userList = userRepository.findAll();
		for (User user : userList) {
			list.add(user);
		}
		return list;
	}

}
