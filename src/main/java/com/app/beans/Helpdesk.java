package com.app.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="helpdesk")
public class Helpdesk {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int helpdeskId;
	private String query;
	private String solution;
	private boolean isResolved;
	private Date createdOn;
	private Date updatedOn;
	
	public Helpdesk() {
		super();
		
	}

	public Helpdesk(int helpdeskId, String query, String solution, boolean isResolved, Date createdOn, Date updatedOn) {
		super();
		this.helpdeskId = helpdeskId;
		this.query = query;
		this.solution = solution;
		this.isResolved = isResolved;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

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

	public boolean isResolved() {
		return isResolved;
	}

	public void setResolved(boolean isResolved) {
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

	@Override
	public String toString() {
		return "Helpdesk [helpdeskId=" + helpdeskId + ", query=" + query + ", solution=" + solution + ", isResolved="
				+ isResolved + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
}
