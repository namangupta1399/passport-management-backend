package com.app.beans;

public class DocumentStatus {
	private int docId;
	private boolean isVerified;
	
	public DocumentStatus() {
		// TODO Auto-generated constructor stub
	}

	public DocumentStatus(int docId, boolean isVerified) {
		super();
		this.docId = docId;
		this.isVerified = isVerified;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
}
