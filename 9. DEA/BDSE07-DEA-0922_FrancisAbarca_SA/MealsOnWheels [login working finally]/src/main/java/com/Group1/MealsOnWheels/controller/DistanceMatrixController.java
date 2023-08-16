//package com.Group1.MealsOnWheels.controller;
//
//import com.Group1.MealsOnWheels.Entity.Meal_Order;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.Group1.MealsOnWheels.repository.OrderRepository;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import com.Group1.MealsOnWheels.repository.OrderRepository;
//
//@RestController
//@RequestMapping("/distance")
//public class DistanceMatrixController {
//    private final String API_KEY = "AIzaSyBKwt4NuTqH__0QG_rq7MYeVFCNnvX4tVc";
//
//    private final OrderRepository orderRepository;
//
//    public DistanceMatrixController(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }
//
//    @PostMapping("/{origin}/{destination}")
//    public Object getDistance(@PathVariable String origin, @PathVariable String destination) {
//        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
//                + origin + "&destinations=" + destination + "&key=" + API_KEY;
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
//
//        if (responseEntity.getStatusCode().is2xxSuccessful()) {
//            try {
//                ObjectMapper mapper = new ObjectMapper();
//                JsonNode root = mapper.readTree(responseEntity.getBody());
//                int distance = root.path("rows").path(0).path("elements").path(0).path("distance").path("value").asInt();
//                String originAddress = root.path("origin_addresses").path(0).asText();
//                String destinationAddress = root.path("destination_addresses").path(0).asText();
//                String durationText = root.path("rows").path(0).path("elements").path(0).path("duration").path("text").asText();
//                int durationNum = root.path("rows").path(0).path("elements").path(0).path("duration").path("value").asInt();
//
//                Meal_Order order = new Meal_Order();            // Replace this to read the latest order status
//                order.setFrom_address(destinationAddress);
//                order.setTo_address(originAddress);
//                orderRepository.save(order);
//
//                if (distance < 10000) {     // Less than 10 KM
//                    Map<String, Object> response = new HashMap<>();
//                    response.put("From", originAddress);
//                    response.put("To", destinationAddress);
//                    response.put("Status", "Food will be delivered hot");
//                    response.put("Distance", String.format("%.3f KM", distance / 1000.0));
//                    response.put("Duration", durationText);
//                    return response;
//                } else {                    // More than 10 KM
//                    Map<String, Object> response = new HashMap<>();
//                    response.put("From", originAddress);
//                    response.put("To", destinationAddress);
//                    response.put("Status", "Food will be delivered frozen");
//                    response.put("Distance", String.format("%.3f KM", distance / 1000.0));
//                    response.put("Duration", durationText);
//                    return response;
//                }
//            } catch (Exception e) {
//                return "Error parsing distance. Plese try again later." + e;
//            }
//        } else {
//            return "Error retrieving distance. Please try again later.";
//        }
//    }
//}
