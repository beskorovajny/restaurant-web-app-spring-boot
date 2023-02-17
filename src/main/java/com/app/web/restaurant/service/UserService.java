package com.app.web.restaurant.service;

import com.app.web.restaurant.entity.User;

import java.util.List;

public interface UserService {
    boolean isExistsByEmail(String eMail);
    void saveUser(User user);
    User updateUser(User user);
    User findById(Long id);
    List<User> findAllUsers();
    void deleteById(Long id);
}
