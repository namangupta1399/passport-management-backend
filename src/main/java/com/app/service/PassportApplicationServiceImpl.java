package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.app.validation.PassportApplicationValidation;

@Service
@Transactional
public class PassportApplicationServiceImpl implements IPassportApplicationService {

	Logger logger = LoggerFactory.getLogger(PassportApplicationServiceImpl.class);
	
//	Repositories

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
	
//	Validation
	@Autowired
	PassportApplicationValidation applicationValidation;

	public PassportApplication addPassportApplication(PassportApplication application) {
		logger.info("addPassportApplication() called");

		if (userService.viewUser(application.getUser().getId()) == null) {
			throw new UserNotFoundException("User not found!");
		}

		if (viewPassportApplicationByUserId(application.getUser().getId()) != null) {
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

		applicationValidation.validateApplicationFields(application);
		return applicationRepository.save(application);

	}

	public void deletePassportApplication(int applicationNo) {
		logger.info("deletePassportApplication() called");

		PassportApplication app = viewPassportApplication(applicationNo);
		if (app == null) {
			throw new PassportApplicationNotFoundException("Passport Application not found!");
		}
		applicationRepository.deleteByApNo(applicationNo);
	}

	public void updatePassportApplication(int userId, PassportApplication application) {
		logger.info("updatePassportApplication() called");

		PassportApplication app = viewPassportApplication(application.getApplicationNo());
		if (app == null) {
			throw new PassportApplicationNotFoundException("Passport Application not found!");
		}
		applicationRepository.save(application);
	}

	public PassportApplication viewPassportApplication(int appNo) {
		logger.info("viewPassportApplication() called");
		Optional<PassportApplication> app = applicationRepository.findById(appNo);

		if (!app.isPresent()) {
			throw new PassportApplicationNotFoundException("Passport Application not found!");
		}
		return app.get();
	}

	public PassportApplication viewPassportApplicationByUserId(int userId) {
		logger.info("viewPassportApplicationByUserId() called");

		return applicationRepository.findByUserId(userId);

	}

	@Override
	public List<PassportApplication> getAllPassportApplications() {

		logger.info("getAllPassportApplications() called");

		ArrayList<PassportApplication> list = new ArrayList<>();
		Collection<PassportApplication> passportApplicationList = applicationRepository.findAll();
		if (passportApplicationList.size() <= 0) {
			throw new PassportApplicationListEmptyException("No application found!");
		}
		for (PassportApplication passportApplication : passportApplicationList) {
			list.add(passportApplication);
		}
		return list;
	}

	@Override
	public PassportApplication updateApplicationStatus(boolean status, int appNo) {
		logger.info("updateApplicationStatus() called");
		
		PassportApplication app = viewPassportApplication(appNo);
		if (app != null) {
			app.setApplicationStatus(status);
			return applicationRepository.save(app);
		}
		throw new PassportApplicationNotFoundException("Passport application not found!");
	}

	@Override
	public ApplicationStatus getApplicationStatus(int appNo) {
		logger.info("getApplicationStatus() called");
		
		PassportApplication app = viewPassportApplication(appNo);
		if(app != null) {
			ApplicationStatus status = new ApplicationStatus(appNo, appService.viewPassportApplication(appNo).getApplicationStatus());
			return status;  
		}
		throw new PassportApplicationNotFoundException("Passport Application does not exist!");
	}
}
