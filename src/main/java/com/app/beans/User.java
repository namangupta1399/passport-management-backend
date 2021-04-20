package com.app.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	private String password;
	private String userType;
	@Column(unique = true)
	private String email;
	private Date createdOn;
	private Date updatedOn;
	
	@OneToOne(targetEntity = PassportApplication.class, cascade = CascadeType.ALL)
	@JoinColumn(name="passportApp_fk", referencedColumnName = "userId")
	private PassportApplication passportApplication;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String password, String userType, String email, Date createdOn, Date updatedOn,
			PassportApplication passportApplication) {
		super();
		this.userId = userId;
		this.password = password;
		this.userType = userType;
		this.email = email;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.passportApplication = passportApplication;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public PassportApplication getPassportApplication() {
		return passportApplication;
	}

	public void setPassportApplication(PassportApplication passportApplication) {
		this.passportApplication = passportApplication;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", userType=" + userType + ", email=" + email
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", passportApplication="
				+ passportApplication + "]";
	}
}
