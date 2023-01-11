package com.app.web.restaurant.service.impl;

import com.app.web.restaurant.model.Dish;
import com.app.web.restaurant.repository.DishRepository;
import com.app.web.restaurant.service.DishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    @Override
    public boolean isDishExists(Dish dish) {
        return false;
    }

    @Override
    public void saveDish(Dish dish) {

    }

    @Override
    public Dish updateDish(Dish dish) {
        return null;
    }

    @Override
    public Dish findDishById(Long id) {
        return null;
    }

    @Override
    public List<Dish> findAllDishes() {
        return null;
    }

    @Override
    public void deleteDishById(Long id) {

    }
}
