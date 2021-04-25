package com.app.service;


import com.app.beans.DocumentStatus;
import com.app.exception.PassportApplicationNotFoundException;

public interface IDocumentService {
	
	public DocumentStatus updateDocumentStatus(int docId, boolean status);
}
