package com.app.web.restaurant.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class NavigationController {
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/users/new")
    public String newUser() {
        return "registration";
    }

    @GetMapping("/admin/new-dish")
    public String newDish() {return "create-dish";}
}
