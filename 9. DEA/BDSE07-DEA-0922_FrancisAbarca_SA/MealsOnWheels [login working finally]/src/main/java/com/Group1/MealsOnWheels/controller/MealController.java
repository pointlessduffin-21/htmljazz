package com.Group1.MealsOnWheels.controller;

import com.Group1.MealsOnWheels.Entity.Meal;
import com.Group1.MealsOnWheels.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    @GetMapping("/meals/{id}")
    public ResponseEntity<Meal> getMealById(@PathVariable Long id) {
        return mealRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/createMeal")
    public String addNewMeal(@RequestParam("picture") MultipartFile image,
                                             @ModelAttribute Meal meal) {
        try {
            String imageName = UUID.randomUUID().toString() + "_" + StringUtils.cleanPath(image.getOriginalFilename());

            // Set meal details
            meal.setPhoto(imageName);

            // Save the meal
            Meal savedMeal = mealRepository.save(meal);

            // Path of the image
            String imagePath = "./src/main/resources/static/images/meals/" + savedMeal.getM_id();

            // Save the image file
            Path uploadPath = Paths.get(imagePath);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            try (InputStream inputStream = image.getInputStream()) {
                Path filePath = uploadPath.resolve(imageName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new IOException("Cannot save uploaded file: " + imageName);
            }

            // Set the image path for the meal
            meal.setPhotoPath("/images/meals/" + savedMeal.getM_id() + "/");
            mealRepository.save(meal);

            return "redirect:/kitchen";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PutMapping("/meals/{id}")
    public ResponseEntity<Meal> updateMeal(@PathVariable Long id, @RequestBody Meal meal) {
        return mealRepository.findById(id)
                .map(existingMeal -> {
                    existingMeal.setMeal_name(meal.getMeal_name());
                    existingMeal.setDescription(meal.getDescription());
                    existingMeal.setDuration(meal.getDuration());
                    return ResponseEntity.ok(mealRepository.save(existingMeal));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/meals/{id}")
    public ResponseEntity<Object> deleteMeal(@PathVariable Long id) {
        return mealRepository.findById(id)
                .map(existingMeal -> {
                    mealRepository.delete(existingMeal);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}