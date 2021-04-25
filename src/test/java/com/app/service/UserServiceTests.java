package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.beans.User;
import com.app.exception.EmailInvalidException;
import com.app.repository.UserRepository;

@SpringBootTest
class UserServiceTests {

	@Autowired
	private UserServiceImpl userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	void testAddUserNullEmail() {
		User user  = new User(1,"testpass","applicant","",new Date(),new Date());
		assertEquals("test@abc.com", userService.addUser(user).getEmail());
	}
	
	@Test
	void testAddUserValidEmailFail() {
		User user  = new User(1,"Abcd!234","applicant","usergmail.com",new Date(),new Date());
		assertEquals("user@gmail.com", userService.addUser(user).getEmail());
	}
	
	@Test
	void testAddUserValidEmailPass() {
		User user  = new User(1,"Abcd!234","applicant","user@gmail.com",new Date(),new Date());
		when(userService.addUser(user)).thenReturn(user);
		assertEquals("user@gmail.com", userService.addUser(user).getEmail());
	}

	@Test
	void testAddUserNullPassword() {
		User user = new User(1, "", "admin", "testcase@abc.com", new Date(), new Date());
		assertEquals("pass", userService.addUser(user).getPassword());
	}
	
	@Test
	void testPasswordValidationFail() {
		User user = new User(1, "testpass", "applicant", "testuser@gmail.com", new Date(), new Date());
		when(userService.addUser(user)).thenReturn(user);
		assertEquals("testpass", userService.addUser(user).getPassword());
	}
	
	@Test
	void testPasswordValidationPass() {
		User user = new User(1, "Qwerty!23", "applicant", "testuser@gmail.com", new Date(), new Date());
		when(userService.addUser(user)).thenReturn(user);
		assertEquals("Qwerty!23", userService.addUser(user).getPassword());
	}
	

	@Test
	void testAddUserNullRole() {

		User user = new User(1, "Qwerty!23", "", "testcase@abc.com", new Date(), new Date());
		assertEquals("admin", userService.addUser(user).getuserRole());

	}
	
	@Test
	void testUserRoleValidationFail() {
		User user = new User(1, "Qwerty!23", "user", "testcase@abc.com", new Date(), new Date());
		when(userService.addUser(user)).thenReturn(user);
		assertEquals("applicant", userService.addUser(user).getuserRole());
	}
	
	@Test
	void testUserRoleValidationPass() {
		User user = new User(1, "Qwerty!23", "admin", "testcase@abc.com", new Date(), new Date());
		when(userService.addUser(user)).thenReturn(user);
		assertEquals("admin", userService.addUser(user).getuserRole());
	}
	
//	
//	@Test
//	void testAddUser() {
//		User user = new User(1, "Qwerty!123", "applicant", "testuser@gmail.com", new Date(), new Date());
//		when(userService.addUser(user)).thenReturn(user);
//		assertEquals(user, userService.addUser(user));
//	}
//	
////	Not working
//	@Test
//	void testGetUser() {
//		System.out.println("Test get user");
//		User user = new User(1, "Qwerty!123", "applicant", "testuser@gmail.com", new Date(), new Date());
////		userService.addUser(user);
//		when(userService.getUser(1)).thenReturn(user);
//		assertEquals(user, userService.getUser(1));
//	}

}
