package com.app.web.restaurant.controller;

import com.app.web.restaurant.model.User;
import com.app.web.restaurant.model.enums.Role;
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

    @PostMapping("/users/save")
    public String saveUser(User user) {
        user.setRole(Role.USER);
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/{id}")
    public String findUserById(@PathVariable("id") Long id, Model model) {
        List<User> users = List.of(userService.findUserById(id));
        log.info("User by ID: [" + users + "]");
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/admin/users")
    public String findAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        log.info("Users found: [" + users + "]");
        model.addAttribute("users", users);
        log.info("Users from model: [" + model.getAttribute("users") + "]");
        return "users";
    }

    @GetMapping("/admin/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

}
