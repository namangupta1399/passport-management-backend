package com.app.service;

import com.app.beans.Helpdesk;
import com.app.beans.PassportApplication;
import com.app.beans.User;

public interface IApplicantService {
	
	User addUser(User user);

	void deleteUser(User user);

	void updateUser(int userId, User user);

	User viewUser(int userId);
	
	PassportApplication addPassportApplication(PassportApplication application);
	
	void deletePassportApplication(PassportApplication application);
	
	void updatePassportApplication(int userId, PassportApplication application);
	
	PassportApplication viewPassportApplication(int userId);
	
	Helpdesk addHelpDeskQuery(Helpdesk helpDeskQuery);
	
	void updateHelpDeskQuery(int applicantId, Helpdesk helpDeskQuery);
}
