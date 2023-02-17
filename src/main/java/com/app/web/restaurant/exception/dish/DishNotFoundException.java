package com.app.web.restaurant.exception.dish;

public class DishNotFoundException extends IllegalArgumentException {
    public DishNotFoundException() {
    }

    public DishNotFoundException(String message) {
        super(message);
    }

    public DishNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
