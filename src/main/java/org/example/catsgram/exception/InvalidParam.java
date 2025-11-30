package org.example.catsgram.exception;


public class InvalidParam extends RuntimeException {
    public InvalidParam(String message) {
        super(message);
    }
}