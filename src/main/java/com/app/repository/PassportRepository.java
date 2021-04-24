package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.beans.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Integer> {
	Passport findByPassportNo(String passNo);
	
	@Query("SELECT p from Passport p WHERE p.passportApplication.applicationNo=?1")
	Passport findByApplicationNo(int appNo);
}
