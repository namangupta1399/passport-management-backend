package com.app.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passportApplications")
public class PassportApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int applicationNo;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String placeOfBirth;
	private String maritalStatus;
	private boolean isIndian;
	private String employmentType;
	private String educationalQualification;
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "add_fk", referencedColumnName = "applicationNo")
	private Address address;
	@OneToMany(targetEntity = Document.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "document_fk", referencedColumnName = "applicationNo")
	private List<Document> documents;
	private boolean applicationStatus;
	private Date createdOn;
	private Date updatedOn;
	
	public PassportApplication() {
		// TODO Auto-generated constructor stub
	}

	public PassportApplication(int applicationNo, String firstName, String middleName, String lastName, String gender,
			Date dateOfBirth, String placeOfBirth, String maritalStatus, boolean isIndian, String employmentType,
			String educationalQualification, Address address, List<Document> documents, boolean applicationStatus,
			Date createdOn, Date updatedOn) {
		super();
		this.applicationNo = applicationNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.maritalStatus = maritalStatus;
		this.isIndian = isIndian;
		this.employmentType = employmentType;
		this.educationalQualification = educationalQualification;
		this.address = address;
		this.documents = documents;
		this.applicationStatus = applicationStatus;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public int getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public boolean isIndian() {
		return isIndian;
	}

	public void setIndian(boolean isIndian) {
		this.isIndian = isIndian;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getEducationalQualification() {
		return educationalQualification;
	}

	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public boolean isApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(boolean applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "PassportApplication [applicationNo=" + applicationNo + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", placeOfBirth=" + placeOfBirth + ", maritalStatus=" + maritalStatus + ", isIndian=" + isIndian
				+ ", employmentType=" + employmentType + ", educationalQualification=" + educationalQualification
				+ ", address=" + address + ", documents=" + documents + ", applicationStatus=" + applicationStatus
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
}