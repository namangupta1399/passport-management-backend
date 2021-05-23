package com.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Address;
import com.app.beans.ApplicationStatus;
import com.app.beans.Document;
import com.app.beans.Passport;
import com.app.beans.PassportApplication;
import com.app.exception.PassportAlreadyIssuedException;
import com.app.exception.PassportApplicationAlreadyExists;
import com.app.exception.PassportApplicationListEmptyException;
import com.app.exception.PassportApplicationNotFoundException;
import com.app.exception.PassportNotFoundException;
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
	private PassportServiceImpl passportService;

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

	/**
	 * The method is used to create new passport application
	 * @param passport application to be inserted
	 * @return passport application
	 * @throws UserNotFoundException to check if user is valid
	 * @throws PassportApplicationAlreadyExists to check if the application already exists
	 */
	public PassportApplication addPassportApplication(PassportApplication application) {
		logger.info("addPassportApplication() called");

		PassportApplication oldApp =  applicationRepository.findByUserId(application.getUser().getId());
		
		if (userService.getUser(application.getUser().getId()) == null) {
			throw new UserNotFoundException("User not found!");
		}

		if (oldApp != null) {
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
		application.setUser(userService.getUser(application.getUser().getId()));

		applicationValidation.validateApplicationFields(application);
		return applicationRepository.save(application);

	}

	/**
	 * The method is used to delete passport application
	 * @param application id to find and delete id
	 * @return nothing
	 */
	public void deletePassportApplication(int applicationNo) {
		logger.info("deletePassportApplication() called");

		PassportApplication app = getPassportApplication(applicationNo);
		if (app != null) {
			applicationRepository.deleteByApNo(applicationNo);
		}
	}

	/**
	 * The method is used to update a passport application
	 * @param application is the updated application 
	 * @return updated application
	 */
	public PassportApplication updatePassportApplication(PassportApplication application) {
		logger.info("updatePassportApplication() called");

		PassportApplication app = getPassportApplicationByUserId(application.getUser().getId());
		if (app != null) {
			applicationValidation.validateApplicationFields(application);
			return applicationRepository.save(application);
		}
		return app;
	}

	/**
	 * The method is used to get passport application
	 * @param application no to find the application
	 * @return passport application
	 */
	public PassportApplication getPassportApplication(int appNo) {
		logger.info("viewPassportApplication() called");
		Optional<PassportApplication> app = applicationRepository.findById(appNo);

		if (!app.isPresent()) {
			throw new PassportApplicationNotFoundException("Passport Application not found!");
		}
		return app.get();
	}

	/**
	 * The method is used to get a passport application
	 * @param user id to get application
	 * @return passport application
	 */
	public PassportApplication getPassportApplicationByUserId(int userId) {
		logger.info("viewPassportApplicationByUserId() called");
		PassportApplication app = applicationRepository.findByUserId(userId);
		if(app != null) {
			return app;
		}
		throw new PassportApplicationNotFoundException("Passport Application not found!");

	}

	/**
	 * The method is used to get all passport applications
	 * @param nothing
	 * @return List<PassportApplication>
	 * @throws PassportApplicationListEmptyException
	 */
	public List<PassportApplication> getAllPassportApplications() {

		logger.info("getAllPassportApplications() called");

		ArrayList<PassportApplication> list = new ArrayList<>();
		Collection<PassportApplication> passportApplicationList = applicationRepository.findAll();
		if (passportApplicationList.isEmpty()) {
			throw new PassportApplicationListEmptyException("No application found!");
		}
		for (PassportApplication passportApplication : passportApplicationList) {
			list.add(passportApplication);
		}
		return list;
	}

	/**
	 * The method is used to update a passport application
	 * @param updated status
	 * @param application no
	 * @return updated application
	 * @throws PassportApplicationNotFoundException
	 */
	@Override
	public PassportApplication updateApplicationStatus(boolean status, int appNo) {
		logger.info("updateApplicationStatus() called");
		
		PassportApplication app = getPassportApplication(appNo);
		if (app != null) {
			app.setApplicationStatus(status);
			
//			Passport passport = passportService.getPassportByApp(appNo);
//			if(passport != null) {
//				throw new PassportAlreadyIssuedException("Passport already issued! Cannot update application status.");
//			}
			
			return applicationRepository.save(app);
		}
		throw new PassportApplicationNotFoundException("Passport application not found!");
	}

	/**
	 * The method is used to get application status
	 * @param application no to get application status
	 * @return ApplicationStatus
	 * @throws PassportApplicationNotFoundException
	 */
	@Override
	public ApplicationStatus getApplicationStatus(int appNo) {
		logger.info("getApplicationStatus() called");
		
		PassportApplication app = getPassportApplication(appNo);
		if(app != null) {
			return new ApplicationStatus(appNo, appService.getPassportApplication(appNo).getApplicationStatus());  
		}
		throw new PassportApplicationNotFoundException("Passport Application does not exist!");
	}
}
