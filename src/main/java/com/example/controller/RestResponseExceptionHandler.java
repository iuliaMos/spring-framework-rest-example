package com.example.controller;

import com.example.dto.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.Locale;

@ControllerAdvice
public class RestResponseExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler
    protected ResponseEntity<ErrorMessage> handleError(final Exception ex, final WebRequest request) {
        ErrorMessage message = new ErrorMessage(LocalDate.now(), ex.getMessage());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorMessage> handleGlobalExceptions(MethodArgumentNotValidException ex,
                                                                  WebRequest request) {
        String messageString = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> {
                    String messageCode = err.getObjectName() + "." + err.getField() + "." + err.getCode();
                    String messageStr = messageSource.getMessage(messageCode, new Object[]{}, Locale.getDefault());
                    return err.getField() + ": " + messageStr;
                })
                .collect(java.util.stream.Collectors.joining(", "));

        ErrorMessage message = new ErrorMessage(LocalDate.now(), messageString);

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
