package com.pagepulse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalideUrlException.class)
    public ResponseEntity<Map<String, String>> handleInvalidUrl(
            InvalideUrlException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(NoHtmlContentException.class)
    public ResponseEntity<Map<String, String>> handleNonHtml(
            NoHtmlContentException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body(error);
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public ResponseEntity<Map<String, String>> handleTimeout(
            SocketTimeoutException ex) {

        Map<String, String> error = new HashMap<>();
        error.put("error", "Request timed out");

        return ResponseEntity
                .status(HttpStatus.GATEWAY_TIMEOUT)
                .body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(
            MethodArgumentNotValidException ex) {

        Map<String, String> error = new HashMap<>();

        error.put(
                "error",
                ex.getBindingResult()
                        .getFieldError()
                        .getDefaultMessage()
        );

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneric(
            Exception ex) {

        ex.printStackTrace();

        Map<String, String> error = new HashMap<>();
        error.put("error", "Internal Server Error");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

}