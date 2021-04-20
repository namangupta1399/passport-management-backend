package com.app.beans;

import javax.persistence.OneToOne;

public class Address {
	private int id;
	private String houseNo;
	private String street;
	private String state;
	private String district;
	private String pinCode;
	private String mobileNo;
	
	@OneToOne(mappedBy = "address")
	private PassportApplication passportApplication;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String houseNo, String street, String state, String district, String pinCode,
			String mobileNo) {
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.street = street;
		this.state = state;
		this.district = district;
		this.pinCode = pinCode;
		this.mobileNo = mobileNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNo=" + houseNo + ", street=" + street + ", state=" + state + ", district="
				+ district + ", pinCode=" + pinCode + ", mobileNo=" + mobileNo + "]";
	}
}
