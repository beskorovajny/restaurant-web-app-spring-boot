package com.app.web.restaurant.service;

import com.app.web.restaurant.entity.Dish;

import java.util.List;

public interface DishService {
    boolean isExists(Dish dish);

    void save(Dish dish);

    Dish update(Dish dish);

    Dish findById(Long id);

    List<Dish> findAll();

    void deleteById(Long id);
}
