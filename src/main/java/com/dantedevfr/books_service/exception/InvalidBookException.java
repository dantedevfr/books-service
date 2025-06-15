package com.dantedevfr.books_service.exception;
import java.util.List;

public class InvalidBookException extends RuntimeException {
    private final List<String> errors;

    public InvalidBookException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
