package com.app.service;

import java.util.List;

import com.app.beans.Helpdesk;
import com.app.beans.PassportApplication;
import com.app.beans.User;

public interface IAdminService {
	
	List<User> getAllUsers();
	
	List<PassportApplication> getAllPassportApplications();
	
	List<Helpdesk> getAllHelpDesk();
	
	Helpdesk getHelpdesk(int userId);
	
	void deleteHelpDesk(int userId, Helpdesk helpDesk);
	
}
