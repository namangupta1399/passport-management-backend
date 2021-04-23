package com.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.beans.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{


}
