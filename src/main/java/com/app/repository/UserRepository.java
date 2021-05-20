package com.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.beans.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);

//	@Query("SELECT u FROM User u WHERE u.userRole='applicant'")
//	List<User> findAllApplicant();
}
