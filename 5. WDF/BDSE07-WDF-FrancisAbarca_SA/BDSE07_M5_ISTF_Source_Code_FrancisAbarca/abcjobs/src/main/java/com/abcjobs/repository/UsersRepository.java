package com.abcjobs.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abcjobs.model.*;

// Users Repository
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	@Query(value = "SELECT * FROM users ORDER BY user_id DESC LIMIT 1", nativeQuery = true) 
	String getLastUser();
	
	@Query(value = "SELECT * FROM users WHERE :email = email AND :password = password", nativeQuery = true)	// Compare User Password if True
	Users login(@Param("email") String email, @Param("password") String password);

	@Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)	// Compare User Email if True
	String checkEmail(@Param("email") String email);
}
