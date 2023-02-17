package com.app.web.restaurant.service;

import com.app.web.restaurant.entity.User;

import java.util.List;

public interface UserService {
    boolean isExistsByEmail(String eMail);

    void save(User user);

    User update(User user);

    User findById(Long id);

    List<User> findAll();

    void deleteById(Long id);
}
