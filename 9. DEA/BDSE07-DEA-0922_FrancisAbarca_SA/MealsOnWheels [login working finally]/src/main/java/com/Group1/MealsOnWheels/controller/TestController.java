package com.Group1.MealsOnWheels.controller;

import com.Group1.MealsOnWheels.Entity.Fund;
import com.Group1.MealsOnWheels.Entity.Meal;
import com.Group1.MealsOnWheels.Entity.Meal_Order;
import com.Group1.MealsOnWheels.repository.FundsRepository;
import com.Group1.MealsOnWheels.repository.MealRepository;
import com.Group1.MealsOnWheels.repository.OrderRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    MealRepository mealRepository;

    public TestController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/greeting")
    public String getGreeting() {
        return "Hello, World!";
    }

    @GetMapping("/getAllMeals")
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    private final String API_KEY = "AIzaSyBKwt4NuTqH__0QG_rq7MYeVFCNnvX4tVc";

    private final OrderRepository orderRepository;

    @PostMapping("/{origin}/{destination}")
    public Object getDistance(@PathVariable String origin, @PathVariable String destination) {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
                + origin + "&destinations=" + destination + "&key=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(responseEntity.getBody());
                int distance = root.path("rows").path(0).path("elements").path(0).path("distance").path("value").asInt();
                String originAddress = root.path("origin_addresses").path(0).asText();
                String destinationAddress = root.path("destination_addresses").path(0).asText();
                String durationText = root.path("rows").path(0).path("elements").path(0).path("duration").path("text").asText();
                int durationNum = root.path("rows").path(0).path("elements").path(0).path("duration").path("value").asInt();

                Meal_Order order = new Meal_Order();            // Replace this to read the latest order status
                order.setFrom_address(destinationAddress);
                order.setTo_address(originAddress);
                orderRepository.save(order);

                if (distance < 10000) {     // Less than 10 KM
                    Map<String, Object> response = new HashMap<>();
                    response.put("From", originAddress);
                    response.put("To", destinationAddress);
                    response.put("Status", "Food will be delivered hot");
                    response.put("Distance", String.format("%.3f KM", distance / 1000.0));
                    response.put("Duration", durationText);
                    return response;
                } else {                    // More than 10 KM
                    Map<String, Object> response = new HashMap<>();
                    response.put("From", originAddress);
                    response.put("To", destinationAddress);
                    response.put("Status", "Food will be delivered frozen");
                    response.put("Distance", String.format("%.3f KM", distance / 1000.0));
                    response.put("Duration", durationText);
                    return response;
                }
            } catch (Exception e) {
                return "Error parsing distance. Plese try again later." + e;
            }
        } else {
            return "Error retrieving distance. Please try again later.";
        }
    }

    @Autowired
    private FundsRepository fundsRepository;

    @GetMapping("/allfunds")
    public ResponseEntity<List<Fund>> getAllFunds() {
        List<Fund> allFunds = fundsRepository.findAll();
        return new ResponseEntity<>(allFunds, HttpStatus.OK);
    }

    @PostMapping("/createfunds")
    public ResponseEntity<Map<String, Object>> createFunds(@RequestBody Fund fund) {
        fund.setDateTime(LocalDateTime.now());
        Fund createdFunds = fundsRepository.save(fund);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Donation added");
        response.put("name", createdFunds.getName());
        response.put("amount", createdFunds.getAmount());
        response.put("dateTime", createdFunds.getDateTime());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/updatefunds/{id}")
    public ResponseEntity<Fund> updateFunds(@PathVariable Long id, @RequestBody Fund fund) {
        Fund existingFund = fundsRepository.findById(id).orElse(null);
        Map<String, Object> response = new HashMap<>();
        if (existingFund == null) {
            response.put("message", "Donation not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingFund.setName(fund.getName());
        existingFund.setAmount(fund.getAmount());
        existingFund.setDateTime(fund.getDateTime());
        response.put("message", "Donation updated");
        Fund updatedFund = fundsRepository.save(existingFund);
        return new ResponseEntity<>(updatedFund, HttpStatus.OK);
    }

    @DeleteMapping("/deletefunds/{id}")
    public ResponseEntity<Void> deleteFunds(@PathVariable Long id) {
        Fund existingFund = fundsRepository.findById(id).orElse(null);
        Map<String, Object> response = new HashMap<>();
        if (existingFund == null) {
            response.put("message", "Donation not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        fundsRepository.delete(existingFund);
        response.put("message", "Donation deleted");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}