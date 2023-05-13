package com.kkr.food_items.Controller;
/**
 * @author - Pradeep
 * Controller controls HTTP requests
 */

import com.kkr.food_items.Model.FoodItems;
import com.kkr.food_items.Repository.FoodItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;



@RestController

public class FoodItemsController {

    private FoodItemsRepository repository;
    FoodItemsController(FoodItemsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/food-items")
    public List<FoodItems> getAllFoodItems() {
        return repository.findAll();
    }

    @GetMapping("/food-items/{id}")
    public FoodItems getFoodItemById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/food-items")
    FoodItems newFoodItems(@RequestBody FoodItems newFoodItems) {
        return repository.save(newFoodItems);
    }
    @PutMapping("/food-items/{id}")
    FoodItems replaceFoodItems(@RequestBody FoodItems newFoodItems, @PathVariable Long id) {

        return repository.findById(id)
                .map(foodItems -> {
                    foodItems.setName(newFoodItems.getName());
                    foodItems.setDescription(newFoodItems.getDescription());
                    foodItems.setPrice(newFoodItems.getPrice());
                    return repository.save(foodItems);
                })
                .orElseGet(() -> {
                    newFoodItems.setId(id);
                    return repository.save(newFoodItems);
                });
    }

    @DeleteMapping("/food-items/{id}")
    void deleteFoodItems(@PathVariable Long id) {
        repository.deleteById(id);
    }

}