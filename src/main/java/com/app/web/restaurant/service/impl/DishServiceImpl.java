package com.app.web.restaurant.service.impl;

import com.app.web.restaurant.model.Dish;
import com.app.web.restaurant.repository.DishRepository;
import com.app.web.restaurant.service.DishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    @Override
    public boolean isExists(Dish dish) {
        return dishRepository.existsById(dish.getId());
    }

    @Override
    public void saveDish(Dish dish) {
        dish.setDateCreated(LocalDateTime.now());
        if (!dishRepository.exists(Example.of(dish))) {
            dishRepository.save(dish);
        }
    }

    @Override
    public Dish updateDish(Dish dish) {
        return null;
    }

    @Override
    public Dish findDishById(Long id) {
        return dishRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Dish> findAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public void deleteDish(Long id) {
        if (dishRepository.existsById(id)) {
            dishRepository.deleteById(id);
        }
    }
}
