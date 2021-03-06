package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.beans.ApplicationStatus;
import com.app.beans.DocumentStatus;
import com.app.beans.Helpdesk;
import com.app.beans.HelpdeskDto;
import com.app.beans.Passport;
import com.app.beans.PassportApplication;
import com.app.beans.PassportApplicationDto;
import com.app.beans.User;
import com.app.beans.UserDto;
import com.app.service.DocumentServiceImpl;
import com.app.service.HelpdeskServiceImpl;
import com.app.service.PassportApplicationServiceImpl;
import com.app.service.PassportServiceImpl;
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private PassportApplicationServiceImpl applicationService;

	@Autowired
	private HelpdeskServiceImpl helpdeskService;

	@Autowired
	private DocumentServiceImpl docService;

	@Autowired
	private PassportServiceImpl passportService;
	
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * The method is used to get all users from db
	 * @param nothing
	 * @return ResponseEntity<List<User>> - returns list of all users
	 */
//	Get all users
	@GetMapping(path = "/users", produces = "application/json")
	public ResponseEntity<List<User>> getAllUsers() {
		logger.info("getAllUser() called");

		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	/**
	 * The method is used to create a new user
	 * @param UserDto
	 * @return ResponseEntity<UserDto> - returns the new user
	 */
	// Create new user
	@PostMapping(path = "/user/new", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
		logger.info("addUser() called");

		User newUser = userService.addUser(modelMapper.map(user, User.class));
		return new ResponseEntity<>(modelMapper.map(newUser, UserDto.class), HttpStatus.OK);
	}

	/**
	 * The method is used to get user by user id
	 * @param nothing
	 * @return ResponseEntity<User>
	 */
	// Get user by userId
	@GetMapping(path = "/user/{id}", produces= "application/json")
	public ResponseEntity<User> getUser(@PathVariable("id") int userId) {
		logger.info("viewUser() called");
		User user = userService.getUser(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	/**
	 * The method is used to delete user
	 * @param user id
	 * @return ResponseEntity<Boolean>
	 */
	// Delete user by id
	@DeleteMapping(path = "/user/delete/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int userId) {
		logger.info("deleteUser() called");
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * The method is used to update user
	 * @param UserDto
	 * @return ResponseEntity<UserDto> - returns the updated user
	 */
	// Update user by id
	@PutMapping(path = "/user/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
		logger.info("updateUser() called");
		User updatedUser = userService.updateUser(user.getId(), modelMapper.map(user, User.class));
		return new ResponseEntity<>(modelMapper.map(updatedUser, UserDto.class), HttpStatus.OK);
	}

	/**
	 * The method is used to get passport application
	 * @param application id
	 * @return ResponseEntity<PassportApplication>
	 */
	// Get passport app by id
	@GetMapping(path = "/application/{id}", produces = "application/json")
	public ResponseEntity<PassportApplication> getPassportApplication(@PathVariable("id") int appId) {
		logger.info("viewPassportApplication() called");
		PassportApplication passApp = applicationService.getPassportApplication(appId);
		return new ResponseEntity<>(passApp, HttpStatus.OK);
	}

	/**
	 * The method is used to get all passport application
	 * @param nothing
	 * @return ResponseEntity<List<PassportApplication>> - list of applications
	 */
//	Get all passport applications
	@GetMapping(path = "/applications", produces = "application/json")
	public ResponseEntity<List<PassportApplication>> getAllPassportApplcations() {
		logger.info("getAllPassportApplications() called");
		List<PassportApplication> applications = applicationService.getAllPassportApplications();
		return new ResponseEntity<>(applications, HttpStatus.OK);
	}

	/**
	 * The method is used to update passport application
	 * @param PassportApplicationDto
	 * @return ResponseEntity<PassportApplication> - updated application
	 */
	// Update passport application by id
	@PutMapping(path = "/application/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PassportApplicationDto> updatePassportApplication(@RequestBody PassportApplicationDto app) {
		logger.info("updatePassportApplication() called");
		PassportApplication updatedApplication = applicationService.updatePassportApplication(modelMapper.map(app, PassportApplication.class));
		return new ResponseEntity<>(modelMapper.map(updatedApplication, PassportApplicationDto.class), HttpStatus.OK);
	}

	/**
	 * The method is used to delete passport application
	 * @param application id
	 * @return ResponseEntity<Boolean>
	 */
	// Delete passport application by id
	@DeleteMapping(path = "/application/delete/{id}", consumes = "application/json")
	public ResponseEntity<Boolean> deletePassportApplication(@PathVariable("id") int appId) {
		logger.info("deletePassportApplication() called");
		applicationService.deletePassportApplication(appId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * The method is used to get all helpdesk queries
	 * @param nothing
	 * @return ResponseEntity<List<Helpdesk>>
	 */
//	Get all helpdesk queries
	@GetMapping(path = "/helpdesk/all", produces = "application/json")
	public ResponseEntity<List<Helpdesk>> getAllHelpdeskQueries() {
		logger.info("getAllHelpDesk() called");

		List<Helpdesk> queries = helpdeskService.getAllHelpDesk();
		return new ResponseEntity<>(queries, HttpStatus.OK);
	}

	/**
	 * The method is used to get helpdesk queries of a user
	 * @param user id
	 * @return ResponseEntity<List<Helpdesk>>
	 */
//	Get all helpdesk queries by user id
	@GetMapping(path = "/helpdesk/{userId}", produces = "application/json")
	public ResponseEntity<List<Helpdesk>> getAllHelpdeskQueries(@PathVariable("userId") int userId) {
		logger.info("getHelpdesk() called");
		List<Helpdesk> queries = helpdeskService.getHelpdeskByUser(userId);
		return new ResponseEntity<>(queries, HttpStatus.OK);
	}

	/**
	 * The method is update a helpdesk query
	 * @param HelpdeskDto
	 * @return ResponseEntity<HelpdeskDto>
	 */
	// Update helpdesk query by id
	@PutMapping(path = "/helpdesk/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<HelpdeskDto> updateHelpdeskQuery(@RequestBody HelpdeskDto query) {
		logger.info("updateHelpDeskQuery() called");
		Helpdesk updatedQuery = helpdeskService.updateHelpDeskQuery(modelMapper.map(query, Helpdesk.class));
		return new ResponseEntity<>(modelMapper.map(updatedQuery, HelpdeskDto.class), HttpStatus.OK);
	}

	/**
	 * The method is used to update application status
	 * @param application no
	 * @return ResponseEntity<PassportApplication>
	 */
	// Update application status
	@PutMapping(path = "/application/status/update", consumes= "application/json", produces = "application/json")
	public ResponseEntity<PassportApplication> updateApplicationStatus(@RequestBody ApplicationStatus applicationStatus) {
		logger.info("updateApplicationStatus() called");
		PassportApplication app = applicationService.updateApplicationStatus(applicationStatus.getStatus(), applicationStatus.getAppNo());
		return new ResponseEntity<>(app, HttpStatus.OK);
	}

	/**
	 * The method is used to get application status
	 * @param application no
	 * @return ResponseEntity<ApplicationStatus>
	 */
//	getApplicationStatus				  
	@GetMapping(path = "/application/status/{appNo}", produces = "application/json")
	public ResponseEntity<ApplicationStatus> getApplicationStatus(@PathVariable("appNo") int appNo) {
		logger.info("viewApplicationStatus() called \n getApplicationStatus() called");

		PassportApplication app = applicationService.getPassportApplication(appNo);
		if (app != null) {
			ApplicationStatus status = applicationService.getApplicationStatus(appNo);

			return new ResponseEntity<>(status, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * The method is used to update document status
	 * @param document id
	 * @param updated status of document
	 * @return ResponseEntity<DocumentStatus>
	 */
	@PutMapping(path = "/application/document/status/update", consumes="application/json" , produces = "application/json")
	public ResponseEntity<DocumentStatus> updateDocumentStatus(@RequestBody DocumentStatus documentStatus) {
		logger.info("updateDocumentStatus() called");
		DocumentStatus docStatus = docService.updateDocumentStatus(documentStatus.getDocId(), documentStatus.getIsVerified());
		if (docStatus != null) {
			return new ResponseEntity<>(docStatus, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * The method is used to issue a new passport
	 * @param application no
	 * @return ResponseEntity<Passport>
	 */
//	Issue new passport
	@PostMapping(path = "/passport/new/{appNo}", produces = "application/json")
	public ResponseEntity<Passport> issueNewPassport(@PathVariable("appNo") int appNo) {
		logger.info("issuePassport() called");
		Passport newPassport = passportService.issuePassport(appNo);
		return new ResponseEntity<>(newPassport, HttpStatus.ACCEPTED);
	}

	/**
	 * The method is used to get passport details
	 * @param passport no
	 * @return ResponseEntity<Passport>
	 */
//	Get passport details
	@GetMapping(path = "/passport/{passNo}", produces = "application/json")
	public ResponseEntity<Passport> getPassport(@PathVariable("passNo") String passNo) {
		logger.info("getPassport() called");
		Passport passport = passportService.getPassport(passNo);
		return new ResponseEntity<>(passport, HttpStatus.OK);
	}
	
	/**
	 * The method is used to get passport details
	 * @param application no
	 * @return ResponseEntity<Passport>
	 */
//	Get passport details by application no
	@GetMapping(path = "/passport/app/{appNo}", produces = "application/json")
	public ResponseEntity<Passport> getPassportByApp(@PathVariable("appNo") int appNo) {
		logger.info("getPassportByApp() called");
		Passport passport = passportService.getPassportByApp(appNo);
		return new ResponseEntity<>(passport, HttpStatus.OK);
	}
	

	/**
	 * The method is used to get passport details
	 * @param passport no
	 * @return ResponseEntity<Passport>
	 */
//	Get passport details
	@GetMapping(path = "/passports", produces = "application/json")
	public ResponseEntity<List<Passport>> getAllPassports() {
		logger.info("getAllPassports() called");
		List<Passport> passports = passportService.getAllPassport();
		return new ResponseEntity<>(passports, HttpStatus.OK);
	}

}
