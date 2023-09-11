package com.Group1.MealsOnWheels.service;

import java.util.List;

import com.Group1.MealsOnWheels.Entity.Meal_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Group1.MealsOnWheels.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepo;

    public void save(Meal_Order order) {
        orderRepo.save(order);
    }
    public Meal_Order getOrder(Long id) {
		return orderRepo.findById(id).get();
	}
    public String getLastOrderNumber() {
        return orderRepo.getLastOrderNumber();
    }
    public List<Meal_Order> getMealsByUId(Long u_id) {
        return orderRepo.getMealsByUId(u_id);
    }

    public List<Meal_Order> getMealsByPId(String partId) {
        return orderRepo.getMealsByPId(partId);
    }

    public List<Meal_Order> getOrdersByVIdAndStatus(String v_id, String status) {
        return orderRepo.getOrdersByVIdAndStatus(v_id, status);
    }

    public List<Meal_Order> getAcceptedOrders() {
		return orderRepo.getAccepted();
	}

	public List<Meal_Order> getOrdered() {

		return orderRepo.getOrdered();
	}

	public List<Meal_Order> getApproved() {

		return orderRepo.getApproved();
	}

	public List<Meal_Order> getAccepted() {

		return orderRepo.getAccepted();
	}
	public List<Meal_Order> getCooked() {

		return orderRepo.getCooked();
	}

    public Meal_Order getMealById(Long mealId) {
    	return orderRepo.getMealById(mealId);
    }

    public Meal_Order findOrderById(Long mealOrderId ){
        return orderRepo.findOrderById(mealOrderId);
    }
}
