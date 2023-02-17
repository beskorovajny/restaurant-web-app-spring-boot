package com.app.web.restaurant.service.impl;

import com.app.web.restaurant.entity.User;
import com.app.web.restaurant.exception.user.UserNotFoundException;
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
    private static final String USER_NOT_FOUND_MSG = "User[ID: %d] not found";
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
            throw new UserNotFoundException(String.format(USER_NOT_FOUND_MSG, user.getId()));
        }
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            log.debug(String.format(USER_NOT_FOUND_MSG, id));
            throw new UserNotFoundException(String.format(USER_NOT_FOUND_MSG, id));
        });
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
