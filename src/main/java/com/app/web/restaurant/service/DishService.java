package com.app.web.restaurant.service;

import com.app.web.restaurant.model.Dish;

import java.util.List;

public interface DishService {
    boolean isDishExists(Dish dish);
    void saveDish(Dish dish);
    Dish updateDish(Dish dish);
    Dish findDishById(Long id);
    List<Dish> findAllDishes();
    void deleteDish(Dish dish);
}
