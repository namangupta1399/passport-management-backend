package com.app.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Helpdesk;
import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.repository.UserRepository;

@Service
public class ApplicantServiceImpl implements IApplicantService{

	@Autowired
	private UserRepository applicantRepository;
	
	@Autowired
	private PassportApplicationRepository applicationRepository;
	
	@Autowired
	private HelpDeskRepository helpdeskRepository;
	

	@Transactional
	@Override
	public User addUser(User user) {
		
		return applicantRepository.add(user);
		
	}

	@Transactional
	@Override
	public void deleteUser(User userId) {
		
		applicantRepository.delete(userId);
	}

	@Transactional
	@Override
	public void updateUser(int userId, User user) {
		applicantRepository.save(user);
		
	}

	@Transactional
	@Override
	public User viewUser(int userId) {
		return applicantRepository.findById(userId).get();
		
	}

	@Transactional
	@Override
	public PassportApplication addPassportApplication(PassportApplication application) {
		
		return applicationRepository.add(application);
		
	}

	@Transactional 
	@Override
	public void deletePassportApplication(Application applicationNo) {
		
		applicantRepository.deleteById(applicationNo);
	}

	@Transactional 
	@Override
	public void updatePassportApplication(int userId, Application application) {
		applicationRepository.save(application);
		
	}
	
	@Transactional 
	@Override
	public PassportApplication viewPassportApplication(int applicationNo) {
		
		return applicationRepository.get(applicationNo);
	}

	@Transactional
	@Override
	public Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery) {
	 
		return helpdeskRepository.add(helpDeskQuery);
		
	}

	@Transactional
	@Override
	public void updateHelpDeskQuery(int userId, Helpdesk helpDeskQuery) {
		
		return helpdeskRepository.save(helpDeskQuery);
		
	}

}
