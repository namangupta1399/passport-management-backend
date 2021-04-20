package com.app.service;

import com.app.beans.Helpdesk;
import com.app.beans.PassportApplication;
import com.app.beans.User;

public interface IApplicantService {
	
	User addUser(User user);

	void deleteUser(User user);

	void updateUser(int userId, User user);

	User viewUser(int userId);
}
