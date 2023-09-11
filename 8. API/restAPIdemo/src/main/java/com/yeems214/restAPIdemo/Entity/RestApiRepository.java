package com.yeems214.restAPIdemo.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestApiRepository extends JpaRepository<User, Integer> {

}