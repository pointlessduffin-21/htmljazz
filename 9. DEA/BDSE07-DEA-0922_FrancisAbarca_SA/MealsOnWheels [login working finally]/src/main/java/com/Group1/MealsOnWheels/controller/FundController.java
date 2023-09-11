//package com.Group1.MealsOnWheels.controller;
//
//import com.Group1.MealsOnWheels.Entity.Fund;
//import com.Group1.MealsOnWheels.repository.FundsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/funds")
//public class FundController {
//
//    @Autowired
//    private FundsRepository fundsRepository;
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Fund>> getAllFunds() {
//        List<Fund> allFunds = fundsRepository.findAll();
//        return new ResponseEntity<>(allFunds, HttpStatus.OK);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Map<String, Object>> createFunds(@RequestBody Fund fund) {
//        fund.setDateTime(LocalDateTime.now());
//        Fund createdFunds = fundsRepository.save(fund);
//        Map<String, Object> response = new HashMap<>();
//        response.put("message", "Donation added");
//        response.put("name", createdFunds.getName());
//        response.put("amount", createdFunds.getAmount());
//        response.put("dateTime", createdFunds.getDateTime());
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Fund> updateFunds(@PathVariable Long id, @RequestBody Fund fund) {
//        Fund existingFund = fundsRepository.findById(id).orElse(null);
//        Map<String, Object> response = new HashMap<>();
//        if (existingFund == null) {
//            response.put("message", "Donation not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        existingFund.setName(fund.getName());
//        existingFund.setAmount(fund.getAmount());
//        existingFund.setDateTime(fund.getDateTime());
//        response.put("message", "Donation updated");
//        Fund updatedFund = fundsRepository.save(existingFund);
//        return new ResponseEntity<>(updatedFund, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteFunds(@PathVariable Long id) {
//        Fund existingFund = fundsRepository.findById(id).orElse(null);
//        Map<String, Object> response = new HashMap<>();
//        if (existingFund == null) {
//            response.put("message", "Donation not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        fundsRepository.delete(existingFund);
//        response.put("message", "Donation deleted");
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
