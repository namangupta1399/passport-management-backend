package com.app.service;

import java.util.List;

import com.app.beans.ApplicationStatus;
import com.app.beans.PassportApplication;

public interface IPassportApplicationService {
	
	PassportApplication addPassportApplication(PassportApplication application);
	
	void deletePassportApplication(int appNo);
	
	PassportApplication updatePassportApplication(int userId, PassportApplication application);
	
	PassportApplication viewPassportApplication(int appNo);
	
	PassportApplication viewPassportApplicationByUserId(int userId);
	
	List<PassportApplication> getAllPassportApplications();
	
	PassportApplication updateApplicationStatus(boolean status, int appNo);
	
	ApplicationStatus getApplicationStatus(int appNo);
}
