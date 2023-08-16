package com.Group1.MealsOnWheels.service;

import java.util.List;

import com.Group1.MealsOnWheels.Entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.MealsOnWheels.repository.MealRepository;

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
    public List<Meal> search(String key) {
        return mealRepo.search(key);
    }
    public Meal getCartOrders(Long mealId) {
        return mealRepo.getCartOrders(mealId);
    }
    public Long getMealIdById(Long mealId) {
        return mealRepo.getMealIdById(mealId);
    }

    public List<Meal> getAllMeals() {
        return mealRepo.findAll();
    }

    public List<Meal> getMealsByUId(Long userId){
        return mealRepo.getMealsByUId(userId);
    }

    public Meal getMealByUId(Long mealId){
        return mealRepo.getMealByUId(mealId);
    }

}
