package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.beans.Address;
import com.app.beans.Document;
import com.app.beans.Passport;
import com.app.beans.PassportApplication;
import com.app.beans.User;
import com.app.repository.PassportRepository;

@SpringBootTest
class PassportServiceTests {
	@MockBean
	PassportRepository passportRepository;
	@Autowired
	PassportServiceImpl passportService;

	@Test
	void TestApplicationNoTrue() {
		User user = new User(178, "peter.1", "applicant", "pcj@gmail.com", new Date(), new Date());
		Address address = new Address(221, "170", "cvb", "Delhi", "xcv", "78451", "8764513296");
		Document documents = new Document(233, "Adhaar", "789465312", false, new Date(), new Date());
		List<Document> doc = new ArrayList<>();
		doc.add(documents);
		PassportApplication passportApplication = new PassportApplication(220, "John", "as", "Will", "Male", new Date(),
				"Bombay", "unmarried", true, "student", "Graduate", address, doc, false, new Date(), new Date(), user);
		Passport passport = new Passport("A2096457", "Indian", new Date(), new Date(), passportApplication);
		when(passportRepository.save(passport)).thenReturn(passport);
		Passport result = passportService.issuePassport(220);
		assertEquals(220, result.getPassportApplication());
	}

	@Test
	void TestApplicationNoFalse() {
		User user = new User(178, "peter.1", "applicant", "pcj@gmail.com", new Date(), new Date());
		Address address = new Address(221, "170", "cvb", "Delhi", "xcv", "78451", "8764513296");
		Document documents = new Document(233, "Adhaar", "789465312", false, new Date(), new Date());
		List<Document> doc = new ArrayList<>();
		doc.add(documents);
		PassportApplication passportApplication = new PassportApplication(220, "John", "as", "Will", "Male", new Date(),
				"Bombay", "unmarried", true, "student", "Graduate", address, doc, false, new Date(), new Date(), user);
		Passport passport = new Passport("A2096457", "Indian", new Date(), new Date(), passportApplication);
		when(passportRepository.save(passport)).thenReturn(passport);
		Passport result = passportService.issuePassport(220);
		assertNotEquals("a", result.getPassportApplication());

	}

	@Test
	void TestApplicationNoNull() {
		User user = new User(178, "peter.1", "applicant", "pcj@gmail.com", new Date(), new Date());
		Address address = new Address(221, "170", "cvb", "Delhi", "xcv", "78451", "8764513296");
		Document documents = new Document(233, "Adhaar", "789465312", false, new Date(), new Date());
		List<Document> doc = new ArrayList<>();
		doc.add(documents);
		PassportApplication passportApplication = new PassportApplication(220, "John", "as", "Will", "Male", new Date(),
				"Bombay", "unmarried", true, "student", "Graduate", address, doc, false, new Date(), new Date(), user);
		Passport passport = new Passport("A2096457", "Indian", new Date(), new Date(), passportApplication);
		when(passportRepository.save(passport)).thenReturn(passport);
		Passport result = passportService.issuePassport(220);
		assertNotEquals(" ", result.getPassportApplication());

	}
}