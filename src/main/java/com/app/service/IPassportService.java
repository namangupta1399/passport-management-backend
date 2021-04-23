package com.app.service;

import java.util.List;

import com.app.beans.Passport;

public interface IPassportService {

	public Passport issuePassport(int appNo);
	
	public Passport getPassport(String passNo);
	
	public List<Passport> getAllPassport();
	
}
