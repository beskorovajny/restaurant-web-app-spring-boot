package com.app.web.restaurant.exception.dish;

public class DishAlreadyExistsException extends Exception {
    public DishAlreadyExistsException() {
    }

    public DishAlreadyExistsException(String message) {
        super(message);
    }

    public DishAlreadyExistsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
