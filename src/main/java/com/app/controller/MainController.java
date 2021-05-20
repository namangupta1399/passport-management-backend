package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.beans.User;
import com.app.beans.UserCredentials;
import com.app.service.LoginServiceImpl;

@RestController
@CrossOrigin
public class MainController {
	
	@Autowired
	private LoginServiceImpl loginService;
	
	/**
	 * The method is used to verify login info.
	 * @param UserCredentials - {email, id, password}
	 * @return ResponseEntity<User> - returns user if user info is valid
	 */
	@PostMapping(path = "/user/login", produces = "application/json", consumes = "application/json")
	public ResponseEntity<User> loginUser(@RequestBody UserCredentials credentials) {
		User user = loginService.loginUser(credentials);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
