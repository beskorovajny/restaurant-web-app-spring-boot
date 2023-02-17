package com.app.web.restaurant.service.impl;

import com.app.web.restaurant.entity.*;
import com.app.web.restaurant.exception.dish.DishNotFoundException;
import com.app.web.restaurant.exception.receipt.ReceiptNotFoundException;
import com.app.web.restaurant.exception.user.UserNotFoundException;
import com.app.web.restaurant.repository.*;
import com.app.web.restaurant.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReceiptServiceImpl implements ReceiptService {
    private static final String RECEIPT_NOT_FOUND_MSG = "Receipt [ID: %d] not found";

    private final ReceiptRepository receiptRepository;
    private final ReceiptHasDishRepository receiptHasDishRepository;
    private final DishRepository dishRepository;
    private final ContactsRepository contactsRepository;
    private final UserRepository userRepository;

    @Override
    public boolean isExists(Receipt receipt) {
        return receiptRepository.existsById(receipt.getId());
    }

    @Override
    public void save(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    @Override
    public Receipt update(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public Receipt findById(Long id) {
        Receipt receipt = receiptRepository.findById(id).orElseThrow(() -> {
            log.debug(String.format(RECEIPT_NOT_FOUND_MSG, id));
            throw new ReceiptNotFoundException(String.format(RECEIPT_NOT_FOUND_MSG, id));
        });
        log.info("Receipt from db: [" + receipt + "]");
        List<ReceiptHasDish> receiptHasDish = receiptHasDishRepository.findAllByReceiptId(receipt.getId()).orElseThrow(() -> {
            log.debug(String.format(RECEIPT_NOT_FOUND_MSG, id));
            throw new ReceiptNotFoundException(String.format(RECEIPT_NOT_FOUND_MSG, id));
        });
        Map<Dish, Integer> receiptDishes = new HashMap<>();
        for (ReceiptHasDish rhd : receiptHasDish) {
            Dish dish = dishRepository.findById(rhd.getDish().getId()).orElseThrow(DishNotFoundException::new);
            receiptDishes.put(dish, rhd.getCount());
        }
        log.info("Dishes for receipt: [" + receiptDishes + "]");
        Contacts contacts = contactsRepository.findById(receipt.getContacts().getId())
                .orElseThrow(IllegalArgumentException::new);
        log.info("Contacts for receipt: [" + contacts + "]");

        User user = userRepository.findById(receipt.getCustomer().getId()).orElseThrow(UserNotFoundException::new);
        log.info("User for receipt: [" + user + "]");

        receipt.setDishes(receiptDishes);
        receipt.setContacts(contacts);
        receipt.setCustomer(user);
        return receipt;
    }

    @Override
    public List<Receipt> findAll() {
        return receiptRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        receiptRepository.deleteById(id);
    }

}
