package com.app.service;

import java.util.List;

import com.app.beans.User;

public interface IUserService {
	
	User addUser(User user);

	void deleteUser(User user);

	void updateUser(int userId, User user);

	User viewUser(int userId);

	public List<User> getAllUsers();
}
