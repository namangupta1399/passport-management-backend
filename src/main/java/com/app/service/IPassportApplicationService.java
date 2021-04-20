package com.app.service;

import java.util.List;

import com.app.beans.PassportApplication;

public interface IPassportApplicationService {
	
	PassportApplication addPassportApplication(PassportApplication application);
	
	void deletePassportApplication(PassportApplication application);
	
	void updatePassportApplication(int userId, PassportApplication application);
	
	PassportApplication viewPassportApplication(int userId);
	
	List<PassportApplication> getAllPassportApplications();
}
