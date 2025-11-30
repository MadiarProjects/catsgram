package org.example.catsgram.exception;


import java.time.LocalDateTime;

public class ErrorResponce {
    private String error;
    private LocalDateTime dateTime;

    public ErrorResponce(String error) {
        this.error = error;
        this.dateTime = LocalDateTime.now();
    }

    public String getError() {
        return error;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
