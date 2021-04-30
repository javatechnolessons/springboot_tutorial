package com.javatechnolessons.demo.exception;

/**
 * Represents a technical exception
 * @author javatechnolessons
 * @version 2.0
 */
public class TechnicalException extends RuntimeException{

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    
    
}
