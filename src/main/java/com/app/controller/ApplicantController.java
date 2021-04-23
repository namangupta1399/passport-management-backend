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
import com.app.beans.Helpdesk;
import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.service.HelpdeskServiceImpl;
import com.app.service.PassportApplicationServiceImpl;
import com.app.service.PassportServiceImpl;
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	Logger logger = LoggerFactory.getLogger(ApplicantController.class);
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private PassportApplicationServiceImpl applicationService;
	
	@Autowired
	private HelpdeskServiceImpl helpdeskService;
	
	@Autowired
	private PassportServiceImpl passService;


	  // Create new user
	  @PostMapping(path = "/user/new", consumes = "application/json", produces = "application/json") 
	  public ResponseEntity<User> createUser(@RequestBody User user) { 
		  
		  logger.info("addUser() called"); 
		  
		  User newUser = userService.addUser(user); 
		  return new ResponseEntity<User>(newUser, HttpStatus.OK);
	  }
	  
	  // Get user by userId
	  @GetMapping(path = "/user/{id}", consumes = "application/json")
	  public ResponseEntity<User> getUser(@PathVariable("id") int userId) { 
		  
		  logger.info("viewUser() called"); 
		  
		  User user = userService.viewUser(userId);
		  return new ResponseEntity<User>(user, HttpStatus.OK); }
	  
	  
	  // Delete user by id
	  @DeleteMapping(path = "/user/delete/{id}", consumes = "application/json")
	  public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int userId) { 
		  
		  logger.info("deleteUser() called"); 
		  
		  userService.deleteUser(userId);
		  return new ResponseEntity<>(HttpStatus.OK); }
	  
	  // Update user by id
	  @PutMapping(path = "/user/update", consumes = "application/json", produces = "application/json")
	  public ResponseEntity<User> updateUser(@RequestBody User user){ 
		  
		  logger.info("updateUser() called"); 
		  
		  User updatedUser = userService.updateUser(user.getId(), user);
		  return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	  }
	  
	  // Create passport application
	  @PostMapping(path = "/application/new", consumes = "application/json", produces = "application/json")
	  public ResponseEntity<PassportApplication> createPassport(@RequestBody PassportApplication app) { 
		  
		  logger.info("addPassportApplication() called"); 
		  
		  applicationService.addPassportApplication(app);
		  return new ResponseEntity<>(app, HttpStatus.OK); }
	  
	// Get passport app by app id
		  @GetMapping(path = "/application/{id}", consumes = "application/json")
		  public ResponseEntity<PassportApplication> getPassportApplication(@PathVariable("id") int appId) { 
			  
			  logger.info("viewPassportApplication() called"); 
			  
			  PassportApplication passApp = applicationService.viewPassportApplication(appId);
			  return new ResponseEntity<>(passApp, HttpStatus.OK); 
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
				  return new ResponseEntity<>(HttpStatus.OK);
			  }
	
			// Create new helpdesk query
			  @PostMapping(path = "/helpdesk/query/new", consumes = "application/json", produces = "application/json") 
			  public ResponseEntity<Helpdesk> createHelpdeskQuery(@RequestBody Helpdesk query) { 
				  
				  logger.info("addHelpDeskQuery() called"); 
				  
				  helpdeskService.addHelpDeskQuery(query); 
				  return new ResponseEntity<>(query, HttpStatus.OK);
			  }
			  
//				Get all helpdesk queries by user id
				@GetMapping(path = "/helpdesk/query/{userId}", produces = "application/json")
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
					  
					  helpdeskService.updateHelpDeskQuery(query);
					  return new ResponseEntity<>(query, HttpStatus.OK);
				  }				  
				  
//				  getApplicationStatus				  
				  @GetMapping(path = "/application/status/{appNo}", produces = "application/json")
				  public ResponseEntity<ApplicationStatus> getApplicationStatus(@PathVariable("appNo") int appNo) {
					  logger.info("viewPassportApplication() called \n getApplicationStatus() called"); 
					  
					  ApplicationStatus status = applicationService.getApplicationStatus(appNo);
					  return new ResponseEntity<>(status, HttpStatus.OK);
				  }
				  

}
