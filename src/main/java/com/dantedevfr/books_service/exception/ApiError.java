package com.dantedevfr.books_service.exception;
import java.time.LocalDateTime;

public class ApiError {
    private String message;
    private String code;
    private int status;
    private LocalDateTime timestamp;

    public ApiError(String message, String code, int status) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
