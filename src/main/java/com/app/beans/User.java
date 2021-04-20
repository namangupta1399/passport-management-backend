package com.app.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	private String password;
	private String userRole;
	@Column(unique = true)
	private String email;
	@CreationTimestamp
	private Date createdOn;
	@UpdateTimestamp
	private Date updatedOn;
	
	@OneToOne(targetEntity = PassportApplication.class, cascade = CascadeType.ALL)
	private PassportApplication passportApplication;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String password, String userRole, String email, Date createdOn, Date updatedOn,
			PassportApplication passportApplication) {
		super();
		this.userId = userId;
		this.password = password;
		this.userRole = userRole;
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

	public String getuserRole() {
		return userRole;
	}

	public void setuserRole(String userRole) {
		this.userRole = userRole;
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
		return "User [userId=" + userId + ", password=" + password + ", userRole=" + userRole + ", email=" + email
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", passportApplication="
				+ passportApplication + "]";
	}
}
