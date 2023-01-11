package com.app.web.restaurant.repository;

import com.app.web.restaurant.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DishRepository extends JpaRepository<Dish, Long>, PagingAndSortingRepository<Dish, Long> {
}
