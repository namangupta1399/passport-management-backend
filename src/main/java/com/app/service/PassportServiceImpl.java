package com.app.service;


import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Passport;
import com.app.beans.PassportApplication;
import com.app.repository.PassportRepository;

@Service
@Transactional
public class PassportServiceImpl implements IPassportService {
	
	Logger logger = LoggerFactory.getLogger(PassportServiceImpl.class);
	
	@Autowired
	private PassportRepository passRepository;
	
	@Autowired
	private PassportApplicationServiceImpl appService;

	@Override
	public Passport issuePassport(int appNo) {
		
		logger.info("issuePassport() called"); 
		
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
		
		logger.info("getPassport() called"); 
		
		// TODO Auto-generated method stub
		return passRepository.findByPassportNo(passNo);
	}

	@Override
	public List<Passport> getAllPassport() {
		
		logger.info("getAllPassport() called");
		
		// TODO Auto-generated method stub
		return passRepository.findAll();
	}

	
}
