package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.beans.Helpdesk;

public interface HelpdeskRepository extends JpaRepository<Helpdesk, Integer> {

}
