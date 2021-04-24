package com.app.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.beans.Address;
import com.app.beans.Document;
import com.app.service.PassportApplicationServiceImpl;

public class PassportApplicationServiceImplTest {

	@Autowired
	private PassportApplicationServiceImpl applicationService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void testAddFirstNameNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1,"","Mathews","Brown","male",
				new Date(), "New Delhi","single", true, "self-employed","Phd",
				new Address(), documentList ,false, new Date(), new Date(), new User());
		
		assertEquals("Patrick",application.getFirstName());
		
	}
	
	@Test
	public void testAddLasttNameNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1,"Greg","Mathews","","male",
				new Date(), "New Delhi","single", true, "self-employed","Phd",
				new Address(), documentList ,false, new Date(), new Date(), new User());
		
		assertEquals("Brown",application.getLastName());
		
	}
	
	@Test
	public void testAddGenderNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1,"Greg","Mathews","Brown","",
				new Date(), "New Delhi","single", true, "self-employed","Phd",
				new Address(), documentList ,false, new Date(), new Date(), new User());
		
		assertEquals("male",application.getGender());
		
	}
	
	
	
	
	
}
