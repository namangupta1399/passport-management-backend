package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.repository.PassportApplicationRepository;
import com.app.beans.Address;
import com.app.beans.Document;
import com.app.service.PassportApplicationServiceImpl;

@SpringBootTest
class PassportApplicationServiceImplTest {

	@Autowired
	private PassportApplicationServiceImpl applicationService;
	
	@MockBean
	private PassportApplicationRepository applicationRepository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
		
	@Test
	public void testFirstNameNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1,"","Mathews","Brown","male",
				new Date(), "New Delhi","single", true, "self-employed","Phd",
				new Address(200,"221B","Baker Street","Delhi","South Delhi","564732","9867543248"), documentList ,false, new Date(), new Date(), new User(1,"password","admin","test@abc.com",new Date(),new Date()));
	
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application,applicationService.addPassportApplication(application));
		
	}
	
	
	@Test
	public void testLastNameNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1,"Greg","Mathews","","male",
				new Date(), "New Delhi","single", true, "self-employed","Phd",
				new Address(200,"221B","Baker Street","Delhi","South Delhi","564732","9867543248"), documentList ,false, new Date(), new Date(), new User(1,"password","admin","test@abc.com",new Date(),new Date()));
	
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application,applicationService.addPassportApplication(application));
		
	}
	
	
	
	@Test
	public void testMaritalStatusNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1,"Greg","Mathews","Brown","male",
				new Date(), "New Delhi","", true, "self-employed","Phd",
				new Address(200,"221B","Baker Street","Delhi","South Delhi","564732","9867543248"), documentList ,false, new Date(), new Date(), new User(1,"password","admin","test@abc.com",new Date(),new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application,applicationService.addPassportApplication(application));
		
	}
	
	@Test
	public void testApplicationNotNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1,"Greg","Mathews","Brown","male",
				new Date(), "New Delhi","single", true, "self-employed","Phd",
				new Address(200,"","Baker Street","Delhi","South Delhi","564732","9867543248"), documentList ,false, new Date(), new Date(), new User(1,"password","admin","test@abc.com",new Date(),new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(123,applicationService.addPassportApplication(application));
		
	}
	
	
}
