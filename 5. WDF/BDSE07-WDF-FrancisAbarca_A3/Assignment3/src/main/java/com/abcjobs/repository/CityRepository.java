package com.abcjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abcjobs.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
