package com.app.repository;

public interface IAdminDao {
	void addAdmin(Admin admin);

	void deleteAdmin(Admin admin);

	void updateAdmin(int adminId, Admin admin);

	Admin viewAdmin(int adminId);
	
	void addPassportApplication(Admin admin);
	
	void deletePassportApplication(Admin admin);
	
	void updatePassportApplication(int applicantId, Admin admin);
	
	Applicant viewPassportApplication(int applicantId);
	
	void addHelpDeskQuery(HelpDeskQuery helpDeskQuery);
	
	void updateHelpDeskQuery(int applicantId, HelpDeskQuery helpDeskQuery);
}
