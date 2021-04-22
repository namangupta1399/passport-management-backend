package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.beans.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
	Passport findByPassportNo(String passNo);
}
