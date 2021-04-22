package com.app.service;

import java.util.List;

import com.app.beans.Passport;
import com.app.beans.PassportApplication;

public interface IPassportService {

	public Passport issuePassport(int appNo);
	
	public Passport getPassport(int passId);
	
	public List<Passport> getAllPassport();
	
}
