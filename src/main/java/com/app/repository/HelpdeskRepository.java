package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.beans.Helpdesk;

@Repository
public interface HelpdeskRepository extends JpaRepository<Helpdesk, Integer> {

}
