package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.app.beans.Address;
import com.app.exception.PassportApplicationFieldException;

@Component
public class AddressValidation {
	
//	Pattern check method
	private boolean validatePattern(String regex, String input) {
		return Pattern.matches(regex, input);		
	}

//	Validating all the fields in Address object
	public boolean validateAddressFields(Address address) {
//		Check house no
		if(address.getHouseNo().isEmpty()) {
			throw new PassportApplicationFieldException("Field House no. cannot be empty");
		}
//		Check street
		if(address.getStreet().isEmpty()) {
			throw new PassportApplicationFieldException("Field Street cannot be empty");
		}
//		Check state
		if(address.getState().isEmpty()) {
			throw new PassportApplicationFieldException("Field State cannot be empty");
		}
//		Check pin code
		if(!validatePinCode(address.getPinCode())) {
			throw new PassportApplicationFieldException("Field pin code cannot be empty");
		}
//		Check mobile no
		if(!validateMobileNo(address.getMobileNo())) {
			throw new PassportApplicationFieldException("Mobile no. is invalid");
		}
		return true;
	}
	
	private boolean validatePinCode(String pinCode) {
		return validatePattern("^[1-9][0-9]{5}$", pinCode);
	}

	private boolean validateMobileNo(String mobileNo) {
		return validatePattern("^[789]\\d{9}$", mobileNo);
	}
	
}
