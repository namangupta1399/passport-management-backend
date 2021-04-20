package com.app.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="documents")
public class Document {
	@Id
	@GeneratedValue
	private int documentId; 
	private String documentName;
	private String documentValue;
	private boolean isVerified;
	private Date addedOn;
	private Date updatedOn;
	
	public Document() {
		super();
	}

	public Document(int documentId, String documentName, String documentValue, Boolean isVerified, Date addedOn,
			Date updatedOn) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.documentValue = documentValue;
		this.isVerified = isVerified;
		this.addedOn = addedOn;
		this.updatedOn = updatedOn;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentValue() {
		return documentValue;
	}

	public void setDocumentValue(String documentValue) {
		this.documentValue = documentValue;
	}

	public boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", documentName=" + documentName + ", documentValue=" + documentValue
				+ ", isVerified=" + isVerified + ", addedOn=" + addedOn + ", updatedOn=" + updatedOn + "]";
	}
	
	
}
