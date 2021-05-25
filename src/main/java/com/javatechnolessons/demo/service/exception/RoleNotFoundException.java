package com.javatechnolessons.demo.service.exception;

public class RoleNotFoundException extends RuntimeException{

    public RoleNotFoundException(Long id, Throwable cause) {
        super("Role with id="+id+ " not found", cause);
    }
 
}
