package com.javatechnolessons.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.javatechnolessons.demo.dto.EmployeeDTO;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void employeeWithLombokTest(){
        EmployeeDTO emp1 = new EmployeeDTO();
        EmployeeDTO emp2 = new EmployeeDTO();
        emp1.setId(Long.valueOf(1));
        emp1.setFirstName("Juan");
        emp2.setId(Long.valueOf(1));
        emp2.setFirstName("Ana");
        assertEquals(emp1, emp2);
        
    }
    
}
