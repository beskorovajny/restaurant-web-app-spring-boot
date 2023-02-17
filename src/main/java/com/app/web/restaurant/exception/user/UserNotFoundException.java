package com.app.web.restaurant.exception.user;

public class UserNotFoundException extends IllegalArgumentException {
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
