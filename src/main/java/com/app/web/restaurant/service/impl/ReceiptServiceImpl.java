package com.app.web.restaurant.service.impl;

import com.app.web.restaurant.model.Receipt;
import com.app.web.restaurant.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Override
    public boolean isReceiptExists(Receipt receipt) {
        return false;
    }

    @Override
    public void saveReceipt(Receipt receipt) {

    }

    @Override
    public Receipt updateReceipt(Receipt receipt) {
        return null;
    }

    @Override
    public Receipt findReceiptById(Long id) {
        return null;
    }

    @Override
    public List<Receipt> findAllReceipts() {
        return null;
    }

    @Override
    public void deleteReceiptById(Receipt receipt) {

    }
}
