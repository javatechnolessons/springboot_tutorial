package com.javatechnolessons.demo.rest.controller;

import java.util.List;

import com.javatechnolessons.demo.dto.EmployeeDTO;
import com.javatechnolessons.demo.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long id) {
        return employeeService.get(id);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAll();
    }

    @PostMapping("/new")
    EmployeeDTO newEmployee(@RequestBody EmployeeDTO newEmployee) {
      return employeeService.save(newEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
      employeeService.delete(id);
    }

    @PutMapping("/update")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO updatedEmployee){
      return employeeService.save(updatedEmployee);
    }
}
