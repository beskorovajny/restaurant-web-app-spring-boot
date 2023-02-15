package com.app.web.restaurant.controller;

import com.app.web.restaurant.model.Dish;
import com.app.web.restaurant.repository.DishRepository;
import com.app.web.restaurant.service.DishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class DishController {
    private final DishRepository dishRepository;
    private final DishService dishService;

    @GetMapping("/customer/menu")
    public String findAllDishes(Model model) {
        List<Dish> dishes = dishService.findAllDishes();
        log.info("Dishes found: [" + dishes + "]");
        model.addAttribute("dishes", dishes);
        log.info("Dishes from model: [" + model.getAttribute("dishes") + "]");
        return "menu";
    }
}
