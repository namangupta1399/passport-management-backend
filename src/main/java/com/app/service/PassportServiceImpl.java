package com.app.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Passport;
import com.app.beans.PassportApplication;
import com.app.exception.PassportNotFoundException;
import com.app.repository.PassportRepository;

@Service
@Transactional
public class PassportServiceImpl implements IPassportService {
	
	@Autowired
	private PassportRepository passRepository;
	
	@Autowired
	private PassportApplicationServiceImpl appService;

	@Override
	public Passport issuePassport(int appNo) {
		// TODO Auto-generated method stub
		PassportApplication application = appService.viewPassportApplication(appNo);
		if(application != null) {
			if(application.getApplicationStatus()) {
				Passport newPassport = new Passport();
				int passportNo = (int) (Math.random() * 10000000);
				newPassport.setPassportNo(String.valueOf(passportNo));
				newPassport.setNationality(application.getIsIndian() ? "Indian" : "Others");
				
				Calendar calendar = Calendar.getInstance();

				newPassport.setDateOfIssue(calendar.getTime());
				calendar.add(Calendar.YEAR, 10);
				newPassport.setDateOfExpiry(calendar.getTime());
				
				newPassport.setPassportApplication(application);
				
				return passRepository.save(newPassport);
			}
		}
		return null;
	}

	@Override
	public Passport getPassport(String passNo) {
		// TODO Auto-generated method stub
		Passport passport = passRepository.findByPassportNo(passNo);
		if(passport == null) {
			throw new PassportNotFoundException("Passport not found with passport number: " + passNo);
		}
		return passport;
	}

	@Override
	public List<Passport> getAllPassport() {
		// TODO Auto-generated method stub
		return passRepository.findAll();
	}

	
}
