package com.javatechnolessons.demo.service.exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(Long id, Throwable cause) {
        super("Employee with id="+id+ " not found", cause);
    }
 
}
