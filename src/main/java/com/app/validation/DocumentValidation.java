package com.app.validation;

import java.util.regex.Pattern;

import com.app.beans.Document;
import com.app.exception.PassportApplicationFieldException;

public class DocumentValidation {
	
//	Pattern check method
	private boolean validatePattern(String regex, String input) {
		if(input.isEmpty()) {
			return false;
		}
		return Pattern.matches(regex, input);
	}


//	Validating all the fields in Document object
	public boolean validateDocumentFields(Document document) {
		String docName = document.getDocumentName().toLowerCase();
		if(docName.equals("aadhaar") || docName.equals("pan")) {
			if(docName.equals("aadhaar") && !validateAadhaar(document.getDocumentValue())) {
				throw new PassportApplicationFieldException("Aadhaar no. is invalid");
			}
			if(docName.equals("pan") && !validatePan(document.getDocumentValue())){
				throw new PassportApplicationFieldException("PAN no. is invalid");
			}
		} else {
			throw new PassportApplicationFieldException("Document invalid");
		}
		return true;
	}
	
	private boolean validateAadhaar(String aadhaar) {
		return validatePattern("^[2-9]{1}[0-9]{3}\\\s[0-9]{4}\\\s[0-9]{4}$", aadhaar);
	}
	
	private boolean validatePan(String pan) {
		return validatePattern("[A-Z]{5}[0-9]{4}[A-Z]{1}", pan);
	}
}
