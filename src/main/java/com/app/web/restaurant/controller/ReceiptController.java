package com.app.web.restaurant.controller;

import com.app.web.restaurant.entity.Receipt;
import com.app.web.restaurant.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ReceiptController {
    private final ReceiptService receiptService;
    @GetMapping("/admin/receipts")
    public String showAllReceipts(Model model) {
        List<Receipt> receipts = receiptService.findAll();
        log.info("Receipts found: [" + receipts + "]");
        model.addAttribute("receipts", receipts);
        return "admin";
    }

    @GetMapping("/receipts/{id}")
    public String showReceiptDetails(@PathVariable("id") Long id, Model model) {
        Receipt receipt = receiptService.findById(id);
        log.info("Receipt by ID: " + receipt);
        model.addAttribute("receipt", receipt);
        return "receipt-details";
    }

    @GetMapping("/admin/receipts/delete/{id}")
    public String deleteReceipt(@PathVariable("id") Long id){
        receiptService.deleteById(id);
        return "redirect:/admin/receipts";
    }

}
