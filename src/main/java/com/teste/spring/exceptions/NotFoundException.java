package com.teste.spring.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() { super("Product not found."); }
 
}
