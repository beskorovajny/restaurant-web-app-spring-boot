package com.app.web.restaurant.exception.receipt;

public class ReceiptAlreadyExistsException extends Exception {
    public ReceiptAlreadyExistsException() {
    }

    public ReceiptAlreadyExistsException(String message) {
        super(message);
    }

    public ReceiptAlreadyExistsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
