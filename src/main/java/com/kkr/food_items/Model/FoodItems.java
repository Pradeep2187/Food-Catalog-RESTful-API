package com.kkr.food_items.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Entity
public class FoodItems {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private double price;
    public FoodItems() {
        // default constructor
    }

    public FoodItems(int id, String name, String description, double price) {
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof FoodItems))
            return false;
        FoodItems foodItems = (FoodItems) o;
        return Objects.equals(this.id, foodItems.id) && Objects.equals(this.name, foodItems.name)
                && Objects.equals(this.description, foodItems.description)
                && Objects.equals(this.price, foodItems.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description, this.price);
    }

    @Override
    public String toString() {
        return "FoodItem{" + "id=" + this.id + ", name='" + this.name + '\'' + ", description='" + this.description + '\'' + ", price='" + this.price+'}';
    }
}
