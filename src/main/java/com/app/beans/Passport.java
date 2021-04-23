package com.app.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private String passportNo;
	
	private String nationality;
	private Date dateOfIssue;
	private Date dateOfExpiry;
	
	@OneToOne(targetEntity = PassportApplication.class, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, unique = true)
	private PassportApplication passportApplication;
	
	public Passport() {
		
	}

	public Passport(String passportNo, String nationality, Date dateOfIssue, Date dateOfExpiry,
			PassportApplication passportApplication) {
		super();
		this.passportNo = passportNo;
		this.nationality = nationality;
		this.dateOfIssue = dateOfIssue;
		this.dateOfExpiry = dateOfExpiry;
		this.passportApplication = passportApplication;
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

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public PassportApplication getPassportApplication() {
		return passportApplication;
	}

	public void setPassportApplication(PassportApplication passportApplication) {
		this.passportApplication = passportApplication;
	}

	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", nationality=" + nationality + ", dateOfIssue=" + dateOfIssue
				+ ", dateOfExpiry=" + dateOfExpiry + ", passportApplication=" + passportApplication + "]";
	}
	
}
