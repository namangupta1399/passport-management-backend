package com.app.service;


import com.app.beans.DocumentStatus;

public interface IDocumentService {
	
	public DocumentStatus updateDocumentStatus(int docId, boolean status);
}
