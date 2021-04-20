package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.beans.User;



public interface ApplicantRepository extends JpaRepository<User, Integer>{


}
