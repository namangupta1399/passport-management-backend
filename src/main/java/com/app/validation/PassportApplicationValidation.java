package com.app.validation;

import org.springframework.stereotype.Component;

import com.app.beans.PassportApplication;
import com.app.exception.PassportApplicationFieldException;

@Component
public class PassportApplicationValidation {
	
//	Validating all the fields in PassportApplication object
	public boolean validateApplicationFields(PassportApplication application) {
//		Check firstName
		if(application.getFirstName().isEmpty()) {
			throw new PassportApplicationFieldException("Applicant first name is invalid. It cannot be blank.");
		}
//		Check lastName
		if(application.getLastName().isEmpty()) {
			throw new PassportApplicationFieldException("Applicant last name is invalid. It cannot be blank.");
		}
//		Check gender
		if(application.getGender().isEmpty()) {
			throw new PassportApplicationFieldException("Gender field cannot be blank");
		}
//		Check date of birth
		if(null == application.getDateOfBirth()) {
			throw new PassportApplicationFieldException("Application DOB cannot be blank");
		}
//		Check place of birth
		if(application.getPlaceOfBirth().isEmpty()) {
			throw new PassportApplicationFieldException("Application place of birth cannot be blank");
		}
//		Check marital status
		if(!checkMaritalStatus(application.getMaritalStatus().toLowerCase())) {
			throw new PassportApplicationFieldException("Available options for the field marital status: Single, Married, Divorced, Widow");
		}
//		Validate address object
		new AddressValidation().validateAddressFields(application.getAddress());
		
//		Validate documents
		DocumentValidation docValidation = new DocumentValidation();
		application.getDocuments().forEach(docValidation::validateDocumentFields);
		
		return true;
	}
	
//	Check marital status
	private boolean checkMaritalStatus(String maritalStatus) {
		if(maritalStatus.isEmpty()) {
			throw new PassportApplicationFieldException("Marital status cannot be blank");
		}
		return maritalStatus.equals("widow") || maritalStatus.equals("divorced") || maritalStatus.equals("single") || maritalStatus.equals("married");
	}
}
