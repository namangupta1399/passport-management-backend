package com.app.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private String passportNo;
	
	private String nationality;
	private String dateOfIssue;
	private String dateOfExpiry;
	
	public Passport() {
		
	}

	public Passport(String passportNo, String nationality, String dateOfIssue, String dateOfExpiry) {
		super();
		this.passportNo = passportNo;
		this.nationality = nationality;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(String dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	
	
	
}
