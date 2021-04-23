package com.app.service;

import java.util.List;

import com.app.beans.User;

public interface IUserService {
	
	User addUser(User user);

	void deleteUser(int userId);

	User updateUser(int userId, User user);

	User viewUser(int userId);

	public List<User> getAllUsers();
}
