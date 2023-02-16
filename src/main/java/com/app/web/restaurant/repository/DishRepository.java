package com.app.web.restaurant.repository;

import com.app.web.restaurant.model.Dish;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long>, PagingAndSortingRepository<Dish, Long> {
    @Override
    <S extends Dish> boolean exists(Example<S> example);

    @Override
    boolean existsById(Long id);

    @Override
    Optional<Dish> findById(Long id);

}
