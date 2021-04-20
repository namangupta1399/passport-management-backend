package com.app.repository;

public interface IApplicantDao {
	void addApplicant(Applicant applicant);

	void deleteApplicant(Applicant applicant);

	void updateApplicant(int applicantId, Applicant applicant);

	Applicant viewApplicant(int applicantId);
	
	void addPassportApplication(Application application);
	
	void deletePassportApplication(Application application);
	
	void updatePassportApplication(int applicantId, Application application);
	
	Applicant viewPassportApplication(int applicantId);
	
	void addHelpDeskQuery(HelpDeskQuery helpDeskQuery);
	
	void updateHelpDeskQuery(int applicantId, HelpDeskQuery helpDeskQuery);
	
}
