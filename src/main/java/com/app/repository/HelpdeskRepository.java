package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.beans.Helpdesk;

@Repository
public interface HelpdeskRepository extends JpaRepository<Helpdesk, Integer> {
	
	public List<Helpdesk> findAllByUserId(int userId);
	
	@Query("DELETE FROM Helpdesk h WHERE h.helpdeskId=?1")
	public void deleteByHelpdeskId(int queryId);
}
