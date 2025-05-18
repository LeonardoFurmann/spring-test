package com.teste.spring.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.teste.spring.exceptions.NotFoundException;
import com.teste.spring.exceptions.RequiredException;

import jakarta.servlet.http.HttpServletRequest;

import com.teste.spring.exceptions.ErrorMessage;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ErrorMessage> notFoundHandler(NotFoundException exception){
        return buildErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequiredException.class)
    private ResponseEntity<ErrorMessage> requiredHandler(RequiredException exception){
        return buildErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGenericException(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();
        return buildErrorResponse("An inespected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorMessage> buildErrorResponse(String message, HttpStatus status) {
        ErrorMessage error = new ErrorMessage(status.value(), message);
        return ResponseEntity.status(status).body(error);
    }
    
}
