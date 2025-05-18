package com.teste.spring.exceptions;

public class RequiredException extends RuntimeException {

   public RequiredException(String fieldName) {
        super("The field '" + fieldName + "' is required.");
    }
 
}
