package com.app.controller;

import java.util.List;

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

import com.app.beans.Helpdesk;
import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.service.AdminServiceImpl;
import com.app.service.HelpdeskServiceImpl;
import com.app.service.PassportApplicationServiceImpl;
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private PassportApplicationServiceImpl applicationService;
	
	@Autowired
	private HelpdeskServiceImpl helpdeskService;

//	Get all users
	@GetMapping(path = "/applicants", produces = "application/json")
		public ResponseEntity<List<User>> getAllUsers() {
			List<User> users = userService.getAllUsers();
			if (users.size() <= 0) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		}

	  // Create new user
	  @PostMapping(path = "/applicant/new", consumes = "application/json", produces = "application/json") 
	  public ResponseEntity<User> createUser(@RequestBody User user) { 
		  User newUser = userService.addUser(user); 
		  return new ResponseEntity<User>(newUser, HttpStatus.OK);
	  }
	  
	  // Get user by userId
	  @GetMapping(path = "/applicant/{id}", consumes = "application/json")
	  public ResponseEntity<User> getUser(@PathVariable("id") int userId) { 
		  User user = userService.viewUser(userId);
		  return new ResponseEntity<User>(user, HttpStatus.OK); }
	  
	  
	  // Delete user by id
	  @DeleteMapping(path = "/delete/{id}", consumes = "application/json")
	  public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int userId) { 
		  userService.deleteUser(userId);
		  return new ResponseEntity<>(HttpStatus.OK); }
	  
	  // Update user by id
	  @PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	  public ResponseEntity<User> updateUser(@RequestBody User user){ 
		  userService.updateUser(user.getUserId(), user);
		  return new ResponseEntity<User>(user, HttpStatus.OK);
	  }
	  
	// Get passport app by userId
		  @GetMapping(path = "/application/{id}", consumes = "application/json")
		  public ResponseEntity<PassportApplication> getPassportApplication(@PathVariable("id") int appId) { 
			  PassportApplication passApp = applicationService.viewPassportApplication(appId);
			  return new ResponseEntity<>(passApp, HttpStatus.OK); 
		  }
		  
//			Get all passport applications
			@GetMapping(path = "/applications", produces = "application/json")
				public ResponseEntity<List<PassportApplication>> getAllPassportApplcations() {
					List<PassportApplication> applications = applicationService.getAllPassportApplications();
					if (applications.size() <= 0) {
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}
					return new ResponseEntity<>(applications, HttpStatus.OK);
				}
			
			// Update passport application by id
			  @PutMapping(path = "/application/update", consumes = "application/json", produces = "application/json")
			  public ResponseEntity<PassportApplication> updatePassportApplication(@RequestBody PassportApplication app){ 
				  applicationService.updatePassportApplication(app.getApplicationNo(), app);
				  return new ResponseEntity<>(app, HttpStatus.OK);
			  }
			  
			// Delete passport application by id
			  @DeleteMapping(path = "/application/delete/{id}", consumes = "application/json")
			  public ResponseEntity<Boolean> deletePassportApplication(@PathVariable("id") int appId) { 
				  applicationService.deletePassportApplication(appId);
				  return new ResponseEntity<>(HttpStatus.OK); }
			  
//				Get all helpdesk queries
				@GetMapping(path = "/helpdesk/all", produces = "application/json")
					public ResponseEntity<List<Helpdesk>> getAllHelpdeskQueries() {
						List<Helpdesk> queries = helpdeskService.getAllHelpDesk();
						if (queries.size() <= 0) {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
						return new ResponseEntity<>(queries, HttpStatus.OK);
					}
				
//				Get all helpdesk queries by user id
				@GetMapping(path = "/helpdesk/{userId}", produces = "application/json")
					public ResponseEntity<List<Helpdesk>> getAllHelpdeskQueries(@PathVariable("userId") int userId) {
						List<Helpdesk> queries = helpdeskService.getHelpdesk(userId);
						if (queries.size() <= 0) {
							return new ResponseEntity<>(HttpStatus.NOT_FOUND);
						}
						return new ResponseEntity<>(queries, HttpStatus.OK);
					}
				
				// Update helpdesk query by id
				  @PutMapping(path = "/helpdesk/update/{id}", consumes = "application/json", produces = "application/json")
				  public ResponseEntity<Helpdesk> updateHelpdeskQuery(@RequestBody Helpdesk query){ 
					  helpdeskService.updateHelpDeskQuery(query.getHelpdeskId(), query);
					  return new ResponseEntity<>(query, HttpStatus.OK);
				  }
				  
				// Delete helpdesk query by id
				  @DeleteMapping(path = "/helpdesk/delete/{id}", consumes = "application/json")
				  public ResponseEntity<Boolean> deleteHelpdeskQuery(@PathVariable("id") int queryId) { 
					  helpdeskService.deleteHelpDesk(queryId);
					  return new ResponseEntity<>(HttpStatus.OK); }

}
