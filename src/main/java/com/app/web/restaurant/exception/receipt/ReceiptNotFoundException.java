package com.app.web.restaurant.exception.receipt;

public class ReceiptNotFoundException extends IllegalArgumentException {
    public ReceiptNotFoundException() {
    }

    public ReceiptNotFoundException(String message) {
        super(message);
    }

    public ReceiptNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
