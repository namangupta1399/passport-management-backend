package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Address;
import com.app.beans.ApplicationStatus;
import com.app.beans.Document;
import com.app.beans.PassportApplication;
import com.app.repository.AddressRepository;
import com.app.repository.DocumentRepository;
import com.app.repository.PassportApplicationRepository;

@Service
@Transactional
public class PassportApplicationServiceImpl implements IPassportApplicationService {
	
	Logger logger = LoggerFactory.getLogger(PassportApplicationServiceImpl.class);
	
	@Autowired
	private PassportApplicationRepository applicationRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private DocumentRepository docsRepository;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private PassportApplicationServiceImpl appService;
	
	
	public PassportApplication addPassportApplication(PassportApplication application) {
		
		logger.info("addPassportApplication() called");
		
		
//		Storing address in db
		Address address = application.getAddress();
		application.setAddress(addressRepository.save(address));
		
//		Storing docs in db
		List<Document> docs = application.getDocuments();
		List<Document> insertedDocs = new ArrayList<>();
		docs.forEach(doc -> insertedDocs.add(docsRepository.save(doc)));
		application.setDocuments(insertedDocs);
		
//		Fetching user from db
		application.setUser(userService.viewUser(application.getUser().getId()));
		
		return applicationRepository.save(application);
		
	}

	 
	public void deletePassportApplication(int applicationNo) {
		
		logger.info("deletePassportApplication() called");
		
		applicationRepository.deleteById(applicationNo);
	}

	
	public void updatePassportApplication(int userId, PassportApplication application) {
		
		logger.info("updatePassportApplication() called");
		
		applicationRepository.save(application);
		
	}
	
	 
	public PassportApplication viewPassportApplication(int appNo) {
		
		logger.info("viewPassportApplication() called");
		
		return applicationRepository.findById(appNo).get();
	}
	
	@Override
	public List<PassportApplication> getAllPassportApplications() {
		
		logger.info("getAllPassportApplications() called");
		
		ArrayList<PassportApplication> list = new ArrayList<>();
		Collection<PassportApplication> passportApplicationList = applicationRepository.findAll();
		for (PassportApplication passportApplication : passportApplicationList) {
			list.add(passportApplication);
		}
		return list;
	}

	@Override
	public PassportApplication updateApplicationStatus(boolean status, int appNo) {
		
		logger.info("updateApplicationStatus() called");
		
		PassportApplication app = appService.viewPassportApplication(appNo);
		app.setApplicationStatus(status);
		return applicationRepository.save(app);
	}

	@Override
	public ApplicationStatus getApplicationStatus(int appNo) {
		
		logger.info("getApplicationStatus() called");
		
		ApplicationStatus status = new ApplicationStatus(appNo, appService.viewPassportApplication(appNo).getApplicationStatus());
		return status;
	}
}
