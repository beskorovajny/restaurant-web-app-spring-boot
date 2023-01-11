package com.app.web.restaurant.service;

import com.app.web.restaurant.model.User;

import java.util.List;

public interface UserService {
    boolean isUserExistsByEmail(String eMail);
    void saveUser(User user);
    User updateUser(User user);
    User findUserById(Long ID);
    List<User> findAllUsers();
    void deleteUserById(Long id);
}
