package com.app.beans;

public class ApplicationStatus {
	private int appNo;
	private boolean status;
	public ApplicationStatus() {
		// TODO Auto-generated constructor stub
	}
	public ApplicationStatus(int appNo, boolean status) {
		super();
		this.appNo = appNo;
		this.status = status;
	}
	public int getAppNo() {
		return appNo;
	}
	public void setAppNo(int appNo) {
		this.appNo = appNo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
