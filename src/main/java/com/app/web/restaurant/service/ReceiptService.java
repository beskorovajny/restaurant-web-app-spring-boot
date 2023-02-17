package com.app.web.restaurant.service;

import com.app.web.restaurant.entity.Receipt;

import java.util.List;

public interface ReceiptService {
    boolean isExists(Receipt receipt);

    void save(Receipt receipt);

    Receipt update(Receipt receipt);

    Receipt findById(Long id);

    List<Receipt> findAll();

    void deleteById(Long id);
}
