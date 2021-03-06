package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.beans.Document;
import com.app.beans.DocumentStatus;
import com.app.exception.DocumentNotFoundException;
import com.app.repository.DocumentRepository;

@Service
@Transactional
public class DocumentServiceImpl implements IDocumentService {
	
	Logger logger = LoggerFactory.getLogger(DocumentServiceImpl.class);
	
	@Autowired
	private DocumentRepository docRepository;
	
	/**
	 * The method is used to update document status
	 * @param document id to find the document to be updated
	 * @param status The updated application status
	 * @return DocumentStatus
	 * @throws DocumentNotFoundException
	 */
	public DocumentStatus updateDocumentStatus(int docId, boolean status) {
		logger.info("updateDocumentStatus() called"); 

		Optional<Document> doc = docRepository.findById(docId);
		if(!doc.isPresent()) {
			throw new DocumentNotFoundException("No document found!");
		}
		Document document = doc.get();
		document.setIsVerified(status);
		docRepository.save(document);
		
		return new DocumentStatus(docId, document.getIsVerified());
	}

}
