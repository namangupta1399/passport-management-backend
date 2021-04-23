package com.app.validation;

import org.springframework.stereotype.Component;

import com.app.beans.Helpdesk;
import com.app.exception.HelpdeskQueryException;

@Component
public class HelpdeskValidation {

//	Validating the user query
	public boolean validateUserQuery(Helpdesk query) {
		if(query.getQuery().isEmpty()) {
			throw new HelpdeskQueryException("Query cannot be empty");
		}
		return true;
	}
	
//	Validating the admin response to a query
	public boolean validateAdminResponse(Helpdesk query) {
		if(query.getSolution().isEmpty()) {
			throw new HelpdeskQueryException("Query solution cannot be empty");
		}
		return true;
	}
	
}
