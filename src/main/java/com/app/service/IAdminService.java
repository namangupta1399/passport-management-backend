package com.app.service;

import java.util.List;

import com.app.beans.Helpdesk;
import com.app.beans.PassportApplication;
import com.app.beans.User;

public interface IAdminService {
	
	List<User> getAllUsers();
}
