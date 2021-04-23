package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.beans.Address;
import com.app.beans.ApplicationStatus;
import com.app.beans.Document;
import com.app.beans.PassportApplication;
import com.app.exception.PassportApplicationAlreadyExists;
import com.app.exception.PassportApplicationListEmptyException;
import com.app.exception.PassportApplicationNotFoundException;
import com.app.exception.UserNotFoundException;
import com.app.repository.AddressRepository;
import com.app.repository.DocumentRepository;
import com.app.repository.PassportApplicationRepository;

@Service
@Transactional
public class PassportApplicationServiceImpl implements IPassportApplicationService {
	
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
		
		if(userService.viewUser(application.getUser().getId()) == null) {
			throw new UserNotFoundException("User not found!");
		}
		
		if(viewPassportApplicationByUserId(application.getUser().getId()) != null) {
			throw new PassportApplicationAlreadyExists("Application exists");
		}
		
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
		PassportApplication app = viewPassportApplication(applicationNo);
		if(app == null) {
			throw new PassportApplicationNotFoundException("Passport Application not found!");
		}
		applicationRepository.deleteByApNo(applicationNo);
	}

	
	public void updatePassportApplication(int userId, PassportApplication application) {
		PassportApplication app = viewPassportApplication(application.getApplicationNo());
		if(app == null) {
			throw new PassportApplicationNotFoundException("Passport Application not found!");
		}
		applicationRepository.save(application);
	}
	 
	public PassportApplication viewPassportApplication(int appNo) {
		Optional<PassportApplication> app = applicationRepository.findById(appNo);
		
		if(!app.isPresent()) {
			throw new PassportApplicationNotFoundException("Passport Application not found!");
		}
		return app.get();
	}
	
	public PassportApplication viewPassportApplicationByUserId(int userId) {
		
		return applicationRepository.findByUserId(userId);
	}
	
	@Override
	public List<PassportApplication> getAllPassportApplications() {
		ArrayList<PassportApplication> list = new ArrayList<>();
		Collection<PassportApplication> passportApplicationList = applicationRepository.findAll();
		if(passportApplicationList.size() <= 0) {
			throw new PassportApplicationListEmptyException("No application found!");
		}
		for (PassportApplication passportApplication : passportApplicationList) {
			list.add(passportApplication);
		}
		return list;
	}

	
	  @Override public PassportApplication updateApplicationStatus(boolean status, int appNo) { 
		  PassportApplication app = viewPassportApplication(appNo); 
		  if(app != null) { 
			  app.setApplicationStatus(status); 
			  return applicationRepository.save(app); 
		  } 
		  throw new PassportApplicationNotFoundException("Passport application not found!"); 
	  }
	 

	@Override
	public ApplicationStatus getApplicationStatus(int appNo) {
		PassportApplication app = viewPassportApplication(appNo);
		if(app != null) {
			ApplicationStatus status = new ApplicationStatus(appNo, appService.viewPassportApplication(appNo).getApplicationStatus());
			return status;  
		}
		throw new PassportApplicationNotFoundException("Passport Application does not exist!");
	}
}
