package com.Group1.MealsOnWheels.repository;

import com.Group1.MealsOnWheels.Entity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundsRepository extends JpaRepository<Fund, Long> {

}
