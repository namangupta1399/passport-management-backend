package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.PassportApplication;
import com.app.repository.PassportApplicationRepository;

@Service
@Transactional
public class PassportApplicationServiceImpl implements IPassportApplicationService {
	
	@Autowired
	private PassportApplicationRepository applicationRepository;
	
	@Override
	public List<PassportApplication> getAllPassportApplications() {
		ArrayList<PassportApplication> list = new ArrayList<>();
		Collection<PassportApplication> passportApplicationList = applicationRepository.findAll();
		for (PassportApplication passportApplication : passportApplicationList) {
			list.add(passportApplication);
		}
		return list;
	}
	
public PassportApplication addPassportApplication(PassportApplication application) {
		
		return applicationRepository.save(application);
		
	}

	 
	public void deletePassportApplication(int applicationNo) {
		
		applicationRepository.deleteById(applicationNo);
	}

	
	public void updatePassportApplication(int userId, PassportApplication application) {
		applicationRepository.save(application);
		
	}
	
	 
	public PassportApplication viewPassportApplication(int applicationNo) {
		
		return applicationRepository.findById(applicationNo).get();
	}
	
	@Override
	public void deletePassportApplication(PassportApplication application) {
		// TODO Auto-generated method stub
		applicationRepository.deleteById(application.getApplicationNo());
		
	}
}
