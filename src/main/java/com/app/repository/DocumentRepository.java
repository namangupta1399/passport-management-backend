package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.beans.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
