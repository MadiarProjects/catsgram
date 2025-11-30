package org.example.catsgram.exception;

public class NotFoundedException extends RuntimeException {
    public NotFoundedException(String message) {
        super(message);
    }
}
