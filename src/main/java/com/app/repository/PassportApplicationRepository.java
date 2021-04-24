package com.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.beans.PassportApplication;

@Repository
@Transactional
public interface PassportApplicationRepository extends JpaRepository<PassportApplication, Integer> {
	
	@Modifying
	@Query("DELETE FROM PassportApplication p WHERE p.applicationNo=?1")
	public void deleteByApNo(int appNo);
	
	PassportApplication findByUserId(int userId);
	
}
