package com.merrymeals.mealsonwheels.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merrymeals.mealsonwheels.Entity.Meal;
import com.merrymeals.mealsonwheels.Repsoitory.MealRepository;

@Service
@Transactional
public class MealService {

	@Autowired
	MealRepository mealRepo;
	
	public void save(Meal meal) {
		mealRepo.save(meal);
	}
	
	public Meal get(Long id) {
		return mealRepo.findById(id).get();
	}
	
	public void delete(Long id) {
		mealRepo.deleteById(id);
	}
	
	public List<Meal> searchByKey(String key) {
		return mealRepo.searchByKey(key);
	}
	
}
