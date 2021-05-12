package com.example.controller;

import com.example.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class RestResponseExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<ErrorMessage> handleError(final Exception ex, final WebRequest request) {
        ErrorMessage message = new ErrorMessage(LocalDate.now(), ex.getMessage());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
