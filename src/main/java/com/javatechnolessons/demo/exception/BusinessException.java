package com.javatechnolessons.demo.exception;

/**
 * Represents a business exception
 * @author javatechnolessons
 * @version 2.0
 */
public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    
    
    
}
