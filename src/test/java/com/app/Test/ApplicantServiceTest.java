package com.app.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.beans.User;
import com.app.repository.UserRepository;
import com.app.service.ApplicantServiceImpl;
import com.app.service.UserServiceImpl;


public class ApplicantServiceTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ApplicantServiceImpl applicantService;
	
	@Autowired
	private UserServiceImpl userService;
	
	//@BeforeEach
	//void initUseCase() {
		//applicantService = new ApplicantServiceImpl(userRepository); //RequiredArgsConstructor
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	public void testAddUserNullPassword() {
		
		User user  = new User(1,"","admin","testcase@abc.com",new Date(),new Date());
		
		assertEquals("12bsna",user.getPassword());
		//assertThat(saveUser.getPassword()).isNotNull();
		
	}
	
	@Test
	public void testAddUserNullRole() {
		
		User user  = new User(1,"testpass","","testcase@abc.com",new Date(),new Date());
		
		assertEquals("admin",user.getuserRole());
		
	}
	
	@Test
	public void testAddUserNullEmail() {
		
		User user  = new User(1,"testpass","applicant","",new Date(),new Date());
		assertEquals("test@abc.com",user.getEmail());
		
	}
	
	@Test
	public void testAddUser() {
		
		System.out.println("testAdduser started");
		User user  = new User(1,"testpass","applicant","test@abc.com",new Date(),new Date());
		
		//User saveUser = applicantService.addUser(user);
		when(userService.addUser(user)).thenReturn(user);
		assertEquals(user, userService.addUser(user));
	}
	
	@Test
	public void testGetUserById() {
		
		User user = applicantService.viewUser(22);
		assertThat(user.getId() == 22);
		
	}
	

}
