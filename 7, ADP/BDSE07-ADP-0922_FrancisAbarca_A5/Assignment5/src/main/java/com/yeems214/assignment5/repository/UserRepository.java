package com.yeems214.assignment5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yeems214.assignment5.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserName(String name);
}
