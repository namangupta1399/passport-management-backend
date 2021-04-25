package com.app.service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Passport;
import com.app.beans.PassportApplication;
import com.app.exception.PassportAlreadyIssuedException;
import com.app.exception.PassportApplicationFieldException;
import com.app.exception.PassportApplicationNotFoundException;
import com.app.exception.PassportListEmptyException;
import com.app.exception.PassportNotFoundException;
import com.app.repository.PassportRepository;

@Service
@Transactional
public class PassportServiceImpl implements IPassportService {

	Logger logger = LoggerFactory.getLogger(PassportServiceImpl.class);

	@Autowired
	private PassportRepository passRepository;

	@Autowired
	private PassportApplicationServiceImpl appService;

	/**
	 * The method is used to issue a new passport
	 * @param application number
	 * @return new issued passport
	 * @throws PassportAlreadyIssuedException - if passport already exists
	 * @throws PassportApplicationFieldException - if application is not verified
	 */
	public Passport issuePassport(int appNo) {

		logger.info("issuePassport() called");

		Passport checkPassport = passRepository.findByApplicationNo(appNo);
		if (checkPassport != null) {
			throw new PassportAlreadyIssuedException("Passport already issued: " + checkPassport.getPassportNo());
		}
		PassportApplication application = appService.getPassportApplication(appNo);
		if (application.getApplicationStatus()) {

			Passport newPassport = new Passport();
			int passportNo = (new Random().nextInt() * 10000000);
			newPassport.setPassportNo(String.valueOf(passportNo));
			newPassport.setNationality(application.getIsIndian() ? "Indian" : "Others");

			Calendar calendar = Calendar.getInstance();

			newPassport.setDateOfIssue(calendar.getTime());
			calendar.add(Calendar.YEAR, 10);
			newPassport.setDateOfExpiry(calendar.getTime());

			newPassport.setPassportApplication(application);

			return passRepository.save(newPassport);
		}
		if (!application.getApplicationStatus()) {
			throw new PassportApplicationFieldException("Application is not verfied. Please wait!");
		}
		return null;
	}

	/**
	 * The method is used to get passport details
	 * @param passport number
	 * @return Passport
	 * @throws PassportNotFoundException - if the passport no. is invalid 
	 */
	public Passport getPassport(String passNo) {

		logger.info("getPassport() called");

		Passport passport = passRepository.findByPassportNo(passNo);
		if (passport == null) {
			throw new PassportNotFoundException("Passport not found with passport number: " + passNo);
		}
		return passport;
	}

	/**
	 * The method is used to get list of all passports
	 * @param nothing
	 * @return List of passport
	 * @throws PassportListEmptyException - if there is no passport issed 
	 */
	public List<Passport> getAllPassport() {

		logger.info("getAllPassport() called");
		List<Passport> passports = passRepository.findAll();
		if(passports.isEmpty()) {
			throw new PassportListEmptyException("No passport found!");
		}
		return passports;
	}

}
