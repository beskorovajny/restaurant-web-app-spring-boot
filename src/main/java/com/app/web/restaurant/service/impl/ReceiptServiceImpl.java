package com.app.web.restaurant.service.impl;

import com.app.web.restaurant.model.Receipt;
import com.app.web.restaurant.repository.ReceiptRepository;
import com.app.web.restaurant.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;

    @Override
    public boolean isExists(Receipt receipt) {
        return receiptRepository.existsById(receipt.getId());
    }

    @Override
    public void saveReceipt(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    @Override
    public Receipt updateReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public Receipt findReceiptById(Long id) {
        return receiptRepository.findById(id).orElse(Receipt.builder().build());
    }

    @Override
    public List<Receipt> findAllReceipts() {
        return receiptRepository.findAll();
    }

    @Override
    public void deleteReceipt(Receipt receipt) {
        receiptRepository.delete(receipt);
    }
}
