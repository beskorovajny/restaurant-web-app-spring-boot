package com.app.web.restaurant.service;

import com.app.web.restaurant.entity.Receipt;

import java.util.List;

public interface ReceiptService {
    boolean isExists(Receipt receipt);

    void saveReceipt(Receipt receipt);

    Receipt updateReceipt(Receipt receipt);

    Receipt findReceiptById(Long id);

    List<Receipt> findAllReceipts();

    void deleteReceipt(Long id);
}
