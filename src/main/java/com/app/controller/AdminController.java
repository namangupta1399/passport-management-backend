package com.app.controller;

import java.util.List;

import javax.xml.ws.Response;

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

import com.app.beans.User;
import com.app.service.AdminServiceImpl;
import com.app.service.ApplicantServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
//	Admin Service
	@Autowired
	private AdminServiceImpl adminService;
	
//	Get all users
	@GetMapping(path = "/applicants", produces = "application/json")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = adminService.getAllUsers();
		if(users.size() <= 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	/*
	 * // Create new user
	 * 
	 * @PostMapping(path = "/new", consumes = "application/json", produces =
	 * "application/json") public ResponseEntity<User> createUser(@RequestBody User
	 * user) { User newUser = applicantService.addApplicant(user); return new
	 * ResponseEntity<User>(newUser, HttpStatus.OK); }
	 * 
	 * // Get user by userId
	 * 
	 * @GetMapping(path = "/{id}", consumes = "application/json") public
	 * ResponseEntity<User> getUser(@PathVariable("id") int userId) { User user =
	 * applicantService.viewApplicant(userId); return new ResponseEntity<User>(user,
	 * HttpStatus.OK); }
	 * 
	 * 
	 * // Delete user by id
	 * 
	 * @DeleteMapping(path = "/delete/{id}", consumes = "application/json") public
	 * ResponseEntity<Boolean> deleteUser(@PathVariable("id") int userId) { boolean
	 * userDeleted = applicantService.deleteApplicant(userId); return new
	 * ResponseEntity<>(HttpStatus.OK); }
	 * 
	 * // Update user by id
	 * 
	 * @PutMapping(path = "/update", consumes = "application/json", produces =
	 * "application/json") public ResponseEntity<User> updateUser(@RequestBody User
	 * user){ applicantService.updateApplicant(user.getUserId(), user); return new
	 * ResponseEntity<User>(user, HttpStatus.OK); }
	 */
	
}
