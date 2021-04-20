package com.app.controller;

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

import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.service.ApplicantServiceImpl;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	private ApplicantServiceImpl applicantService;
	
	@PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = applicantService.addUser(user);
		if(user != null) {
			return new ResponseEntity<User>(newUser, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(path = "/{id}", consumes = "application/json")
	public ResponseEntity<User> getUser(@PathVariable("id") int userId) {
		User user = applicantService.viewUser(userId);
		if(user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "/delete/{id}", consumes = "application/json")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int userId) {
		applicantService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		applicantService.updateUser(user.getUserId(), user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

//	Create passport application
	@PostMapping(path = "/passport/new", produces = "application/json", consumes = "application/json")
	public ResponseEntity<PassportApplication> createPassportApplication(PassportApplication application) {
		applicantService.addPassportApplication(application);
		return new ResponseEntity<>(application, HttpStatus.ACCEPTED);
	}
	
//	Get passport application
	@GetMapping(path = "/passport/{appNo}", produces = "application/json")
	public ResponseEntity<PassportApplication> getPassportApplication(@PathVariable("appNo") int appNo){
		PassportApplication application = applicantService.viewPassportApplication(appNo);
		return new ResponseEntity<>(application, HttpStatus.OK);
	}
	
//	Delete passport application
	@DeleteMapping(path = "/passport/delete/{appNo}", consumes = "application/json")
	public ResponseEntity<Boolean> deletePassportApplication(@PathVariable("appNo") int appNo) {
		applicantService.deletePassportApplication(appNo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	Update passport application
	

}
