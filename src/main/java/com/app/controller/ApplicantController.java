package com.app.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
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
import com.app.beans.HelpdeskDto;
import com.app.beans.PassportApplication;
import com.app.beans.PassportApplicationDto;
import com.app.beans.User;
import com.app.beans.UserDto;
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
	
	@Autowired
    private ModelMapper modelMapper;


	  // Create new user
	  @PostMapping(path = "/user/new", consumes = "application/json", produces = "application/json") 
	  public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) { 
		  
		  logger.info("addUser() called"); 
		  
		  User newUser = userService.addUser(modelMapper.map(user, User.class)); 
		  return new ResponseEntity<>(modelMapper.map(newUser, UserDto.class), HttpStatus.OK);
	  }
	  
	  // Get user by userId
	  @GetMapping(path = "/user/{id}", consumes = "application/json")
	  public ResponseEntity<User> getUser(@PathVariable("id") int userId) { 
		  
		  logger.info("viewUser() called"); 
		  
		  User user = userService.getUser(userId);
		  return new ResponseEntity<>(user, HttpStatus.OK); }
	  
	  
	  // Delete user by id
	  @DeleteMapping(path = "/user/delete/{id}", consumes = "application/json")
	  public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int userId) { 
		  
		  logger.info("deleteUser() called"); 
		  
		  userService.deleteUser(userId);
		  return new ResponseEntity<>(HttpStatus.OK); }
	  
	  // Update user by id
	  @PutMapping(path = "/user/update", consumes = "application/json", produces = "application/json")
	  public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user){ 
		  
		  logger.info("updateUser() called"); 
		  
		  User updatedUser = userService.updateUser(user.getId(), modelMapper.map(user, User.class));
		  return new ResponseEntity<>(modelMapper.map(updatedUser, UserDto.class), HttpStatus.OK);
	  }
	  
	  // Create passport application
	  @PostMapping(path = "/application/new", consumes = "application/json", produces = "application/json")
	  public ResponseEntity<PassportApplicationDto> createPassport(@RequestBody PassportApplicationDto app) { 
		  
		  logger.info("addPassportApplication() called"); 
		  
		  PassportApplication newApplication = applicationService.addPassportApplication(modelMapper.map(app, PassportApplication.class));
		  return new ResponseEntity<>(modelMapper.map(newApplication, PassportApplicationDto.class), HttpStatus.OK); }
	  
	// Get passport app by app id
		  @GetMapping(path = "/application/{id}", consumes = "application/json")
		  public ResponseEntity<PassportApplication> getPassportApplication(@PathVariable("id") int appId) { 
			  
			  logger.info("viewPassportApplication() called"); 
			  
			  PassportApplication passApp = applicationService.viewPassportApplication(appId);
			  return new ResponseEntity<>(passApp, HttpStatus.OK); 
		  }
		  

			// Update passport application by id
			  @PutMapping(path = "/application/update", consumes = "application/json", produces = "application/json")
			  public ResponseEntity<PassportApplicationDto> updatePassportApplication(@RequestBody PassportApplicationDto app){ 
				  
				  logger.info("updatePassportApplication() called"); 
				  
				  PassportApplication updatedApplication = applicationService.updatePassportApplication(app.getApplicationNo(), modelMapper.map(app, PassportApplication.class));
				  return new ResponseEntity<>(modelMapper.map(updatedApplication, PassportApplicationDto.class), HttpStatus.OK);
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
			  public ResponseEntity<HelpdeskDto> createHelpdeskQuery(@RequestBody HelpdeskDto query) { 
				  
				  logger.info("addHelpDeskQuery() called"); 
				  
				  Helpdesk newQuery = helpdeskService.addHelpDeskQuery(modelMapper.map(query, Helpdesk.class)); 
				  return new ResponseEntity<>(modelMapper.map(newQuery, HelpdeskDto.class), HttpStatus.OK);
			  }
			  
//				Get all helpdesk queries by user id
				@GetMapping(path = "/helpdesk/query/{userId}", produces = "application/json")
				public ResponseEntity<List<Helpdesk>> getAllHelpdeskQueries(@PathVariable("userId") int userId) {
					logger.info("getHelpdesk() called"); 
					
					List<Helpdesk> queries = helpdeskService.getHelpdeskByUser(userId);
					if (queries.isEmpty()) {
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}
					return new ResponseEntity<>(queries, HttpStatus.OK);
				}
				
				// Update helpdesk query by id
				  @PutMapping(path = "/helpdesk/update/{id}", consumes = "application/json", produces = "application/json")
				  public ResponseEntity<HelpdeskDto> updateHelpdeskQuery(@RequestBody HelpdeskDto query){ 
					  
					  logger.info("updateHelpDeskQuery() called"); 
					  
					  Helpdesk updatedQuery = helpdeskService.updateHelpDeskQuery(modelMapper.map(query, Helpdesk.class));
					  return new ResponseEntity<>(modelMapper.map(updatedQuery, HelpdeskDto.class), HttpStatus.OK);
				  }				  
				  
//				  getApplicationStatus				  
				  @GetMapping(path = "/application/status/{appNo}", produces = "application/json")
				  public ResponseEntity<ApplicationStatus> getApplicationStatus(@PathVariable("appNo") int appNo) {
					  logger.info("viewPassportApplication() called \n getApplicationStatus() called"); 
					  
					  ApplicationStatus status = applicationService.getApplicationStatus(appNo);
					  return new ResponseEntity<>(status, HttpStatus.OK);
				  }
				  

}
