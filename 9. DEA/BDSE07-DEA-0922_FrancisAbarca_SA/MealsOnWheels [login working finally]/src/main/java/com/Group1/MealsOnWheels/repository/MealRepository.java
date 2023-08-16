package com.Group1.MealsOnWheels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Group1.MealsOnWheels.Entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>{
	@Query("SELECT m FROM Meal m WHERE m.meal_name LIKE %:key%")
	public List<Meal> search(@Param("key") String key);

	@Query("SELECT m FROM Meal m WHERE m.m_id = :mealId")
	public Meal getCartOrders(@Param("mealId") Long mealId);
	
	@Query("SELECT o FROM Meal o WHERE o.m_id = :mealId")
	public Long getMealIdById(@Param("mealId") Long mealId);
	
	@Query("SELECT m, o.status, o.order_date FROM Meal m JOIN Meal_Order o ON m.m_id = o.m_id WHERE o.u_id = :userId")
	public List<Meal> getMealsByUId(@Param("userId") Long userId);
	
	@Query("SELECT m FROM Meal m WHERE m.m_id = :mealId")
	public Meal getMealByUId(@Param("mealId") Long mealId);

	
//	SELECT * FROM meal JOIN meal_order o ON meal.m_id = o.m_id WHERE o.u_id = 1


}