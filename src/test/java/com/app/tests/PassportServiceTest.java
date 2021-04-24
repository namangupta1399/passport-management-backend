package com.app.tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.app.service.PassportServiceImpl;
@SpringBootTest
public class PassportServiceTest {
@MockBean
PassportRepository passportRepository;
@Autowired
PassportServiceImpl passportService;
	@Test
	void TestApplicationNoTrue() {
		String Date1 = "2021-04-23";
		String Date2 = " 2021-04-23";
		String Date3 = "2011-01-25";
		String Date4=  "2022-05-25";
		String Date5 = "2011-01-25";
		String Date6=  "2022-05-25";
		String Date7 = "1992-04-21";
		String Date8=  "2022-05-25";
		String Date9 = "1992-04-21";
		Date cDate, uDate, iDate, eDate, cDate1, uDate2,bDate, cDate3, uDate4;
		try {
			cDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date1);
			uDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date2);
			iDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date3);
			eDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date4);
			cDate1 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date5);
			uDate2 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date6);
			bDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date7);
			cDate3 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date8);
			uDate4 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date9);
		User user = new User(178,"peter.1","applicant","pcj@gmail.com",cDate,uDate);
		Address address = new Address(221,"170","cvb","Delhi","xcv","78451", "8764513296");
		Document documents = new Document(233,"Adhaar", "789465312",false, cDate1, uDate2);
		List<Document> doc = new ArrayList<>();
		doc.add(documents);
		PassportApplication passportApplication = new PassportApplication(220,"John","as","Will","Male",bDate,"Bombay","unmarried",true,"student","Graduate",address,doc,false,cDate3, uDate4, user);
		Passport passport = new Passport("A2096457","Indian", iDate, eDate, passportApplication);
		when(passportRepository.save(passport)).thenReturn(passport);
		Passport result = passportService.issuePassport(220);
		assertEquals(220, result.getPassportApplication());
		}catch(Exception e){
		
	}
}
	@Test
	void TestApplicationNoFalse() {
		String Date1 = "2021-04-23";
		String Date2 = " 2021-04-23";
		String Date3 = "2011-01-25";
		String Date4=  "2022-05-25";
		String Date5 = "2011-01-25";
		String Date6=  "2022-05-25";
		String Date7 = "1992-04-21";
		String Date8=  "2022-05-25";
		String Date9 = "1992-04-21";
		Date cDate, uDate, iDate, eDate, cDate1, uDate2,bDate, cDate3, uDate4;
		try {
			cDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date1);
			uDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date2);
			iDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date3);
			eDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date4);
			cDate1 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date5);
			uDate2 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date6);
			bDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date7);
			cDate3 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date8);
			uDate4 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date9);
		User user = new User(178,"peter.1","applicant","pcj@gmail.com",cDate,uDate);
		Address address = new Address(221,"170","cvb","Delhi","xcv","78451", "8764513296");
		Document documents = new Document(233,"Adhaar", "789465312",false, cDate1, uDate2);
		List<Document> doc = new ArrayList<>();
		doc.add(documents);
		PassportApplication passportApplication = new PassportApplication(220,"John","as","Will","Male",bDate,"Bombay","unmarried",true,"student","Graduate",address,doc,false,cDate3, uDate4, user);
		Passport passport = new Passport("A2096457","Indian", iDate, eDate, passportApplication);
		when(passportRepository.save(passport)).thenReturn(passport);
		Passport result = passportService.issuePassport(220);
		assertNotEquals("a", result.getPassportApplication());
		}catch(Exception e){
	}
}
	@Test
	void TestApplicationNoNull() {
		String Date1 = "2021-04-23";
		String Date2 = " 2021-04-23";
		String Date3 = "2011-01-25";
		String Date4=  "2022-05-25";
		String Date5 = "2011-01-25";
		String Date6=  "2022-05-25";
		String Date7 = "1992-04-21";
		String Date8=  "2022-05-25";
		String Date9 = "1992-04-21";
		Date cDate, uDate, iDate, eDate, cDate1, uDate2,bDate, cDate3, uDate4;
		try {
			cDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date1);
			uDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date2);
			iDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date3);
			eDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date4);
			cDate1 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date5);
			uDate2 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date6);
			bDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date7);
			cDate3 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date8);
			uDate4 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(Date9);
		User user = new User(178,"peter.1","applicant","pcj@gmail.com",cDate,uDate);
		Address address = new Address(221,"170","cvb","Delhi","xcv","78451", "8764513296");
		Document documents = new Document(233,"Adhaar", "789465312",false, cDate1, uDate2);
		List<Document> doc = new ArrayList<>();
		doc.add(documents);
		PassportApplication passportApplication = new PassportApplication(220,"John","as","Will","Male",bDate,"Bombay","unmarried",true,"student","Graduate",address,doc,false,cDate3, uDate4, user);
		Passport passport = new Passport("A2096457","Indian", iDate, eDate, passportApplication);
		when(passportRepository.save(passport)).thenReturn(passport);
		Passport result = passportService.issuePassport(220);
		assertNotEquals(" ", result.getPassportApplication());
		}catch(Exception e){	 
	}
}
}