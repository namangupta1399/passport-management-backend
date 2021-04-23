package com.app.service;


import com.app.beans.User;

public interface IApplicantService {
	
	User addUser(User user);

	void deleteUser(int userId);

	void updateUser(int userId, User user);

	User viewUser(int userId);
}
