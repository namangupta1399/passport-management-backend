package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Helpdesk;
import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.repository.HelpdeskRepository;
import com.app.repository.PassportApplicationRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		ArrayList<User> list = new ArrayList<>();
		Collection<User> userList = userRepository.findAll();
		for (User user : userList) {
			list.add(user);
		}
		return list;
	}

}
