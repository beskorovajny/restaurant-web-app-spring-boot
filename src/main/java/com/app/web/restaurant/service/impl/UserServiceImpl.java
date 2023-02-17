package com.app.web.restaurant.service.impl;

import com.app.web.restaurant.entity.Receipt;
import com.app.web.restaurant.entity.User;
import com.app.web.restaurant.exception.receipt.ReceiptNotFoundException;
import com.app.web.restaurant.exception.user.UserNotFoundException;
import com.app.web.restaurant.repository.ReceiptRepository;
import com.app.web.restaurant.repository.UserRepository;
import com.app.web.restaurant.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private static final String USER_NOT_FOUND_MSG = "User[ID: %d] not found";
    private static final String RECEIPTS_FOR_USER_NF_MSG = "Receipts [UserID: %d] not found";
    private final UserRepository userRepository;
    private final ReceiptRepository receiptRepository;

    @Override
    public boolean isExistsByEmail(String eMail) {
        Optional<User> user = userRepository.findByEmail(eMail);
        return user.isPresent();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User update(User user) {
        Optional<User> old = userRepository.findByEmail(user.getEmail());
        if (old.isPresent()) {
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException(String.format(USER_NOT_FOUND_MSG, user.getId()));
        }
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            log.debug(String.format(USER_NOT_FOUND_MSG, id));
            throw new UserNotFoundException(String.format(USER_NOT_FOUND_MSG, id));
        });
        Set<Receipt> receipts = receiptRepository.findAllByCustomerId(user.getId()).orElseThrow(() -> {
            log.debug(String.format(RECEIPTS_FOR_USER_NF_MSG, id));
            throw new ReceiptNotFoundException(String.format(RECEIPTS_FOR_USER_NF_MSG, id));
        });
        user.setReceipts(receipts);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
