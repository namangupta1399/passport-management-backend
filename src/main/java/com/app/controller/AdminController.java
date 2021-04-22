package com.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.app.beans.Passport;
import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.service.DocumentServiceImpl;
import com.app.service.HelpdeskServiceImpl;
import com.app.service.PassportApplicationServiceImpl;
import com.app.service.PassportServiceImpl; 
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	//@Autowired
	//private AdminServiceImpl adminService;
	
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

//	Get all users
	@GetMapping(path = "/applicants", produces = "application/json")
		public ResponseEntity<List<User>> getAllUsers() {
		
		logger.info("getAllUser() called"); 
		
			List<User> users = userService.getAllUsers();
			if (users.size() <= 0) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		}

	  // Create new user
	  @PostMapping(path = "/applicant/new", consumes = "application/json", produces = "application/json") 
	  public ResponseEntity<User> createUser(@RequestBody User user) { 
		  
		  logger.info("addUser() called");
		  
		  User newUser = userService.addUser(user); 
		  return new ResponseEntity<User>(newUser, HttpStatus.OK);
	  }
	  
	  // Get user by userId
	  @GetMapping(path = "/applicant/{id}", consumes = "application/json")
	  public ResponseEntity<User> getUser(@PathVariable("id") int userId) { 
		  
		  logger.info("viewUser() called");
		  
		  User user = userService.viewUser(userId);
		  return new ResponseEntity<User>(user, HttpStatus.OK); }
	  
	  
	  // Delete user by id
	  @DeleteMapping(path = "/delete/{id}", consumes = "application/json")
	  public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int userId) { 
		  
		  logger.info("deleteUser() called");
		  
		  userService.deleteUser(userId);
		  return new ResponseEntity<>(HttpStatus.OK); }
	  
	  // Update user by id
	  @PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	  public ResponseEntity<User> updateUser(@RequestBody User user){ 
		  
		  logger.info("updateUser() called"); 
		  
		  userService.updateUser(user.getId(), user);
		  return new ResponseEntity<User>(user, HttpStatus.OK);
	  }
	  
	// Get passport app by userId
		  @GetMapping(path = "/application/{id}", consumes = "application/json")
		  public ResponseEntity<PassportApplication> getPassportApplication(@PathVariable("id") int appId) { 
			  
			  logger.info("viewPassportApplication() called"); 
			  
			  PassportApplication passApp = applicationService.viewPassportApplication(appId);
			  return new ResponseEntity<>(passApp, HttpStatus.OK); 
		  }
		  
//			Get all passport applications
			@GetMapping(path = "/applications", produces = "application/json")
				public ResponseEntity<List<PassportApplication>> getAllPassportApplcations() {
				
				 logger.info("getAllPassportApplications() called"); 
				
					List<PassportApplication> applications = applicationService.getAllPassportApplications();
					if (applications.size() <= 0) {
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}
					return new ResponseEntity<>(applications, HttpStatus.OK);
				}
			
			// Update passport application by id
			  @PutMapping(path = "/application/update", consumes = "application/json", produces = "application/json")
			  public ResponseEntity<PassportApplication> updatePassportApplication(@RequestBody PassportApplication app){ 
				  
				  logger.info("updatePassportApplication() called"); 
				  
				  applicationService.updatePassportApplication(app.getApplicationNo(), app);
				  return new ResponseEntity<>(app, HttpStatus.OK);
			  }
			  
			// Delete passport application by id
			  @DeleteMapping(path = "/application/delete/{id}", consumes = "application/json")
			  public ResponseEntity<Boolean> deletePassportApplication(@PathVariable("id") int appId) { 
				  
				  logger.info("deletePassportApplication() called");
				  
				  applicationService.deletePassportApplication(appId);
				  return new ResponseEntity<>(HttpStatus.OK); }
			  
//				Get all helpdesk queries
				@GetMapping(path = "/helpdesk/all", produces = "application/json")
					public ResponseEntity<List<Helpdesk>> getAllHelpdeskQueries() {
					
					logger.info("getAllHelpDesk() called");
					
						List<Helpdesk> queries = helpdeskService.getAllHelpDesk();
						if (queries.size() <= 0) {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
						return new ResponseEntity<>(queries, HttpStatus.OK);
					}
				
//				Get all helpdesk queries by user id
				@GetMapping(path = "/helpdesk/{userId}", produces = "application/json")
					public ResponseEntity<List<Helpdesk>> getAllHelpdeskQueries(@PathVariable("userId") int userId) {
					
					logger.info("getHelpdesk() called");
					
						List<Helpdesk> queries = helpdeskService.getHelpdesk(userId);
						if (queries.size() <= 0) {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
						return new ResponseEntity<>(queries, HttpStatus.OK);
					}
				
				// Update helpdesk query by id
				  @PutMapping(path = "/helpdesk/update/{id}", consumes = "application/json", produces = "application/json")
				  public ResponseEntity<Helpdesk> updateHelpdeskQuery(@RequestBody Helpdesk query){ 
					  
					  logger.info("updateHelpDeskQuery() called");
						
					  helpdeskService.updateHelpDeskQuery(query.getHelpdeskId(), query);
					  return new ResponseEntity<>(query, HttpStatus.OK);
				  }
				  
				// Delete helpdesk query by id
				  @DeleteMapping(path = "/helpdesk/delete/{id}", consumes = "application/json", produces = "application/json")
				  public ResponseEntity<Boolean> deleteHelpdeskQuery(@PathVariable("id") int queryId) { 
					  
					  logger.info("deleteHelpDesk() called");
					  
					  helpdeskService.deleteHelpDesk(queryId);
					  return new ResponseEntity<>(HttpStatus.OK); }
				  
				  //Update application status
			  @PutMapping(path = "/application/status/update/{appNo}", produces = "application/json")
			  public ResponseEntity<PassportApplication> updateApplicationStatus(@PathVariable("appNo") int appNo, @RequestBody boolean status) {
				 
				  logger.info("updateApplicationStatus() called");
				  
				  PassportApplication passApp = applicationService.viewPassportApplication(appNo);
				  if(passApp != null) {
					  applicationService.updateApplicationStatus(status, appNo);
					  return new ResponseEntity<>(passApp, HttpStatus.OK);
				  }
				  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			  }
			  
//			  getApplicationStatus				  
			  @GetMapping(path = "/application/status/{appNo}", produces = "application/json")
			  public ResponseEntity<ApplicationStatus> getApplicationStatus(@PathVariable("appNo") int appNo) {
				  
				  logger.info("viewApplicationStatus() called \n getApplicationStatus() called"); 
				  
				  PassportApplication app = applicationService.viewPassportApplication(appNo);
				  if(app != null) {
					  ApplicationStatus status = applicationService.getApplicationStatus(appNo);
					  
					  return new ResponseEntity<>(status, HttpStatus.OK);
				  }
				  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
			  
//			  Update document status
			  @PutMapping(path = "/application/document/status/update/{docId}", produces = "application/json")
			  public ResponseEntity<DocumentStatus> updateDocumentStatus(@PathVariable("docId") int docId, @RequestBody boolean status) {
				 
				  logger.info("updateDocumentStatus() called"); 
				  
				  DocumentStatus docStatus = docService.updateDocumentStatus(docId, status);
				  if(docStatus != null) {
					  return new ResponseEntity<>(docStatus, HttpStatus.OK);
				  }
				  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
			  
//			  Issue new passport
			  @PostMapping(path = "/passport/new/{appNo}", produces = "application/json")
			  public ResponseEntity<Passport> issueNewPassport(@PathVariable("appNo") int appNo) {
				  
				  logger.info("issuePassport() called"); 
				  
				  Passport newPassport = passportService.issuePassport(appNo);
				  if(newPassport != null) {
					  return new ResponseEntity<>(newPassport, HttpStatus.ACCEPTED);
				  }
				  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
			  
//			  Get passport details
			  @GetMapping(path = "/passport/{passNo}", produces = "application/json")
			  public ResponseEntity<Passport> getPassport(@PathVariable("passNo") String passNo) {
				  
				  logger.info("getPassport() called"); 
				  
				  Passport passport = passportService.getPassport(passNo);
				  if(passport != null) {
					  return new ResponseEntity<>(passport, HttpStatus.OK);
				  }
				  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			  }
}

