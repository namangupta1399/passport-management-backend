package com.app.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Helpdesk {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int helpdeskId;
	private String query;
	private String solution;
	private boolean isResolved;
	@CreationTimestamp
	private Date createdOn;
	@UpdateTimestamp
	private Date updatedOn;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private User user;
	
	public Helpdesk() {
		super();
		
	}

	public Helpdesk(int helpdeskId, String query, String solution, boolean isResolved, Date createdOn, Date updatedOn,
			User user) {
		super();
		this.helpdeskId = helpdeskId;
		this.query = query;
		this.solution = solution;
		this.isResolved = isResolved;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.user = user;
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

	@Override
	public String toString() {
		return "Helpdesk [helpdeskId=" + helpdeskId + ", query=" + query + ", solution=" + solution + ", isResolved="
				+ isResolved + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", user=" + user + "]";
	}
}