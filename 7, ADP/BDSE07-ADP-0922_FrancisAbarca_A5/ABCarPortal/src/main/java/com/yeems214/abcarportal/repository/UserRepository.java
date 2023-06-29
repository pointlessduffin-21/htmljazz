package com.yeems214.abcarportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yeems214.abcarportal.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUserName(String name);


}

