package com.backend_project.Shopping_backend_application.exceptions;

public class ProductNotFoundException extends  RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
