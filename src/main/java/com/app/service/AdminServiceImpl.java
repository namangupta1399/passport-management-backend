package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.beans.Helpdesk;
import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.repository.HelpdeskRepository;
import com.app.repository.PassportApplicationRepository;
import com.app.repository.UserRepository;

public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PassportApplicationRepository applicationRepository;
	
	@Autowired
	private HelpdeskRepository helpdeskRepository;

	@Override
	public List<User> getAllUsers() {
		ArrayList<User> list = new ArrayList<>();
		Collection<User> userList = userRepository.findAll();
		for (User user : userList) {
			list.add(user);
		}
		return list;
	}

	@Override
	public List<PassportApplication> getAllPassportApplications() {
		ArrayList<PassportApplication> list = new ArrayList<>();
		Collection<PassportApplication> passportApplicationList = applicationRepository.findAll();
		for (PassportApplication passportApplication : passportApplicationList) {
			list.add(passportApplication);
		}
		return list;
	}

	@Override
	public List<Helpdesk> getAllHelpDesk() {
		ArrayList<Helpdesk> list = new ArrayList<>();
		Collection<Helpdesk> helpdeskList = helpdeskRepository.findAll();
		for (Helpdesk helpdesk : helpdeskList) {
			list.add(helpdesk);
		}
		return list;
	}

	@Override
	public Helpdesk getHelpdesk(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHelpDesk(int userId, Helpdesk helpDesk) {
		// TODO Auto-generated method stub
		
	}

}
