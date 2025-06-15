package com.dantedevfr.books_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiError> handleBookNotFound(BookNotFoundException ex) {
        ApiError error = new ApiError(
                ex.getMessage(),
                "ERR001",
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidBookException.class)
    public ResponseEntity<ApiError> handleInvalidBook(InvalidBookException ex) {
        String message = ex.getMessage() + ": " + String.join(" | ", ex.getErrors());
        ApiError error = new ApiError(
                message,
                "ERR002",
                HttpStatus.UNPROCESSABLE_ENTITY.value()
        );
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneralError(Exception ex) {
        ex.printStackTrace();
        ApiError error = new ApiError(
                "Unexpected server error",
                "ERR500",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
