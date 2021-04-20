package com.app.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class ApplicantServiceImpl implements IApplicantService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PassportApplicationRepository applicationRepository;
	
	@Autowired
	private HelpdeskRepository helpdeskRepository;
	

	
	public User addUser(User user) {
		
		return userRepository.save(user);
		
	}

	
	public void deleteUser(User userId) {
		
		userRepository.delete(userId);
	}

	
	public void updateUser(int userId, User user) {
		userRepository.save(user);
		
	}

	
	public User viewUser(int userId) {
		return userRepository.findById(userId).get();
		
	}

	
	public PassportApplication addPassportApplication(PassportApplication application) {
		
		return applicationRepository.save(application);
		
	}

	 
	public void deletePassportApplication(int applicationNo) {
		
		userRepository.deleteById(applicationNo);
	}

	
	public void updatePassportApplication(int userId, PassportApplication application) {
		applicationRepository.save(application);
		
	}
	
	 
	public PassportApplication viewPassportApplication(int applicationNo) {
		
		return applicationRepository.findById(applicationNo).get();
	}

	
	public Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery) {
	 
		return helpdeskRepository.save(helpDeskQuery);
		
	}

	
	public void updateHelpDeskQuery(int userId, Helpdesk helpDeskQuery) {
		
		helpdeskRepository.save(helpDeskQuery);
		
	}


	@Override
	public void deletePassportApplication(PassportApplication application) {
		// TODO Auto-generated method stub
		applicationRepository.deleteById(application.getApplicationNo());
		
	}

}
