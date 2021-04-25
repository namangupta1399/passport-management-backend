package com.app.service;

import com.app.beans.User;
import com.app.beans.UserCredentials;

public interface ILoginService {

	User loginUser(UserCredentials credentials);
	
}
