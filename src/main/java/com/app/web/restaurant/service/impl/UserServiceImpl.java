package com.app.web.restaurant.service.impl;

import com.app.web.restaurant.model.User;
import com.app.web.restaurant.repository.UserRepository;
import com.app.web.restaurant.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public boolean isExistsByEmail(String eMail) {
        Optional<User> user = userRepository.findByEmail(eMail);
        return user.isPresent();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> old = userRepository.findByEmail(user.getEmail());
        if (old.isPresent()) {
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
