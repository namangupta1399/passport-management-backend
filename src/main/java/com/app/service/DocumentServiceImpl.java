package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Document;
import com.app.beans.DocumentStatus;
import com.app.repository.DocumentRepository;

@Service
@Transactional
public class DocumentServiceImpl implements IDocumentService {
	
	@Autowired
	private DocumentRepository docRepository;
	
	@Override
	public DocumentStatus updateDocumentStatus(int docId, boolean status) {
		Document doc = docRepository.findById(docId).get();
		doc.setIsVerified(status);
		docRepository.save(doc);
		
		DocumentStatus docStatus = new DocumentStatus(docId, doc.getIsVerified());
		return docStatus;
	}

}
