package com.javatechnolessons.demo.controller.advice;

import com.javatechnolessons.demo.service.exception.RoleNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class RoleNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String roleNotFoundHandler(RoleNotFoundException ex) {
        return ex.getMessage();
    }
}
