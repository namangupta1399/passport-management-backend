package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.beans.PassportApplication;

public interface PassportApplicationRepository extends JpaRepository<PassportApplication, Integer> {

}
