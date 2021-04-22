package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.beans.PassportApplication;

@Repository
public interface PassportApplicationRepository extends JpaRepository<PassportApplication, Integer> {

	@Modifying
	@Query(value = "update PassportApplication app set app.applicationStatus=:status where app.applicationNo=:appNo")
	void updateApplicationStatus(@Param("status") Boolean status, @Param("appNo") Integer appNo);
	
}
