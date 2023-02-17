package com.app.web.restaurant.controller;

import com.app.web.restaurant.entity.User;
import com.app.web.restaurant.entity.enums.Role;
import com.app.web.restaurant.service.UserService;
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
public class UserController {
    private final UserService userService;

    @PostMapping("/users/new")
    public String saveUser(User user) {
        user.setRole(Role.USER);
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/update/{id}")
    public String updateUserRole(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user.getRole().equals(Role.USER)) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }
        userService.save(user);
        return ("redirect:/admin/users");
    }

    @GetMapping("/admin/users/{id}")
    public String showUserById(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        log.info("User by ID: [" + user + "]");
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/admin/users")
    public String showAllUsers(Model model) {
        List<User> users = userService.findAll();
        log.info("Users found: [" + users + "]");
        model.addAttribute("users", users);
        log.info("Users from entity: [" + model.getAttribute("users") + "]");
        return "users";
    }

    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin/users";
    }

}
