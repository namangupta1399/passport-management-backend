package com.app.service;

import java.util.List;

import com.app.beans.Document;
import com.app.beans.DocumentStatus;

public interface IDocumentService {
	
	public DocumentStatus updateDocumentStatus(int docId, boolean status);
}
