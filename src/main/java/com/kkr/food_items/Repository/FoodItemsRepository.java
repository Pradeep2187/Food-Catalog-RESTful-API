package com.kkr.food_items.Repository;

import com.kkr.food_items.Model.FoodItems;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FoodItemsRepository extends JpaRepository<FoodItems, Long> {}