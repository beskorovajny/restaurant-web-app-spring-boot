package com.app.web.restaurant.controller;

import com.app.web.restaurant.entity.Dish;
import com.app.web.restaurant.service.DishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class DishController {
    private final DishService dishService;

    @PostMapping({"/admin/dishes/new", "/admin/dishes/update"})
    public String saveDish(Dish dish) {
        dishService.save(dish);
        return "redirect:/admin/dishes";
    }
    @GetMapping("/admin/dishes/edit-form/{id}")
    public String editDishForm(@PathVariable("id") Long id, Model model){
        Dish dish = dishService.findById(id);
        model.addAttribute("dish", dish);
        log.info("Dish for update:[" + dish + "]");
        return "edit-dish";
    }
    /*@PostMapping("admin/dishes/update")
    public String updateDish(Dish dish) {
        dishService.saveDish(dish);
        return "redirect:/admin/dishes";
    }*/

    @GetMapping("/customer/menu")
    public String findAllDishes(Model model) {
        getDishes(model);
        return "menu";
    }

    @GetMapping("/admin/dishes")
    public String findDishesForAdmin(Model model) {
        getDishes(model);
        return "dishes";
    }

    @GetMapping("admin/dishes/delete/{id}")
    public String deleteDish(@PathVariable("id") Long id) {
        dishService.deleteById(id);
        return "redirect:/admin/dishes";
    }

    private void getDishes(Model model) {
        List<Dish> dishes = dishService.findAll();
        log.info("Dishes found: [" + dishes + "]");
        model.addAttribute("dishes", dishes);
        log.info("Dishes from entity: [" + model.getAttribute("dishes") + "]");
    }
}
