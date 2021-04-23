package com.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.beans.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
	
}
