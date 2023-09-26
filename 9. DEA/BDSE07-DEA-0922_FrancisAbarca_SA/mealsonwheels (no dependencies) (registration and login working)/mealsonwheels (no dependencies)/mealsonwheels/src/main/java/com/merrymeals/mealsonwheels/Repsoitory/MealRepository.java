package com.merrymeals.mealsonwheels.Repsoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.merrymeals.mealsonwheels.Entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>{
	@Query(value = "SELECT * FROM meal"
	 		+ " WHERE meal_name LIKE '%' || :key || '%'"
	 		+ " OR ingredients LIKE '%' || :key || '%'"
	 		+ " OR nutrition LIKE '%' || :key || '%'",
	 		nativeQuery = true)
	public List<Meal> searchByKey(@Param("key") String key);
	
}
