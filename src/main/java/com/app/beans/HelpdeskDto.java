package com.app.beans;

import java.util.Date;

public class HelpdeskDto {
	private int helpdeskId;
	private String query;
	private String solution;
	private boolean isResolved;
	private Date createdOn;
	private Date updatedOn;
	private User user;
	
	public int getHelpdeskId() {
		return helpdeskId;
	}
	public void setHelpdeskId(int helpdeskId) {
		this.helpdeskId = helpdeskId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public boolean getIsResolved() {
		return isResolved;
	}
	public void setIsResolved(boolean isResolved) {
		this.isResolved = isResolved;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
