package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.beans.Address;
import com.app.beans.Document;
import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.repository.PassportApplicationRepository;

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
	void testFirstNameNullFail() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);

		PassportApplication application = new PassportApplication(1, "", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "single", true, "self-employed", "Phd",
				new Address(200, "221B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));

		when(applicationService.addPassportApplication(application)).thenReturn(application);
		assertEquals(application, applicationService.addPassportApplication(application));

	}
	
	@Test
	void testFirstNameNullPass() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);

		PassportApplication application = new PassportApplication(1, "Josh", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "single", true, "self-employed", "Phd",
				new Address(200, "221B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));

		when(applicationService.addPassportApplication(application)).thenReturn(application);
		assertEquals(application, applicationService.addPassportApplication(application));

	}

	@Test
	void testLastNameNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);

		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "", "male", new Date(),
				"New Delhi", "single", true, "self-employed", "Phd",
				new Address(200, "221B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));

		when(applicationService.addPassportApplication(application)).thenReturn(application);

		assertEquals(application, applicationService.addPassportApplication(application));

	}
	
	@Test
	void testLastNameNullPass() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);

		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "single", true, "self-employed", "Phd",
				new Address(200, "221B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));

		when(applicationService.addPassportApplication(application)).thenReturn(application);

		assertEquals(application, applicationService.addPassportApplication(application));

	}
	
	@Test
	void testGenderNullPass() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);

		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "", new Date(),
				"New Delhi", "single", true, "self-employed", "Phd",
				new Address(200, "221B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));

		when(applicationService.addPassportApplication(application)).thenReturn(application);

		assertEquals(application, applicationService.addPassportApplication(application));

	}
	
	@Test
	void testDOBNullPass() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);

		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", null,
				"New Delhi", "single", true, "self-employed", "Phd",
				new Address(200, "221B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));

		when(applicationService.addPassportApplication(application)).thenReturn(application);

		assertEquals(application, applicationService.addPassportApplication(application));

	}
	
	@Test
	void testPlaceOfBirthNullPass() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"", "single", true, "self-employed", "Phd",
				new Address(200, "221B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application, applicationService.addPassportApplication(application));
		
	}

	@Test
	void testMaritalStatusNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);

		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "", true, "self-employed", "Phd",
				new Address(200, "221B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));

		when(applicationService.addPassportApplication(application)).thenReturn(application);

		assertEquals(application, applicationService.addPassportApplication(application));

	}
	
	@Test
	void testMaritalStatusFromOptionsFalse() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "null", true, "self-employed", "Phd",
				new Address(200, "221B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application, applicationService.addPassportApplication(application));
		
	}
	
	@Test
	void testMaritalStatusFromOptionsPass() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "Married", true, "self-employed", "Phd",
				new Address(200, "221B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application, applicationService.addPassportApplication(application));
		
	}
	
	@Test
	void testHouseNoNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "Married", true, "self-employed", "Phd",
				new Address(200, "", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application, applicationService.addPassportApplication(application));
		
	}
	
	@Test
	void testStreetNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "Married", true, "self-employed", "Phd",
				new Address(200, "111B", "", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application, applicationService.addPassportApplication(application));
		
	}
	
	@Test
	void testStateNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "Married", true, "self-employed", "Phd",
				new Address(200, "111B", "Baker St", "", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application, applicationService.addPassportApplication(application));
		
	}
	
	@Test
	void testPinCodeNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "Married", true, "self-employed", "Phd",
				new Address(200, "111B", "Baker St", "Delhi", "South Delhi", "", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application, applicationService.addPassportApplication(application));
		
	}
	
	@Test
	void testDocumentNameNull() {
		Document document = new Document(200, "", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "Married", true, "self-employed", "Phd",
				new Address(200, "111B", "Baker St", "Delhi", "South Delhi", "123456", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application, applicationService.addPassportApplication(application));
		
	}
	
	@Test
	void testAadhaarValid() {
		Document document = new Document(200, "Aadhaar", "2343 45327895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "Married", true, "self-employed", "Phd",
				new Address(200, "111B", "Baker St", "Delhi", "South Delhi", "123456", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application, applicationService.addPassportApplication(application));
		
	}
	
	@Test
	void testPanValid() {
		Document document = new Document(200, "pan", "", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);
		
		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "Married", true, "self-employed", "Phd",
				new Address(200, "111B", "Baker St", "Delhi", "South Delhi", "123456", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));
		
		when(applicationService.addPassportApplication(application)).thenReturn(application);
		
		assertEquals(application, applicationService.addPassportApplication(application));
		
	}

	@Test
	void testApplicationNotNull() {
		Document document = new Document(200, "Aadhaar", "2343 4532 7895", true, new Date(), new Date());
		List<Document> documentList = new ArrayList<>();
		documentList.add(document);

		PassportApplication application = new PassportApplication(1, "Greg", "Mathews", "Brown", "male", new Date(),
				"New Delhi", "single", true, "self-employed", "Phd",
				new Address(200, "111B", "Baker Street", "Delhi", "South Delhi", "564732", "9867543248"), documentList,
				false, new Date(), new Date(),
				new User(1, "password", "admin", "test@abc.com", new Date(), new Date()));

		when(applicationService.addPassportApplication(application)).thenReturn(application);

		assertEquals(application, applicationService.addPassportApplication(application));

	}

}
