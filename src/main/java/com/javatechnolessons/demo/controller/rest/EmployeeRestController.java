package com.javatechnolessons.demo.controller.rest;

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
    public EmployeeDTO getEmployee(@PathVariable("id") Long id){
        return employeeService.get(id);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAll(){
        return employeeService.getAll();
    }

    @PostMapping("/new")
    public EmployeeDTO newEmployee(@RequestBody EmployeeDTO employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.delete(id);
    }

    @PutMapping("/update")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employee){
        return employeeService.save(employee);
    }
    /*http://localhost:8080/api/employees/99 (method GET) -> get employee with id=99
http://localhost:8080/api/employees/all (method GET) -> get all employees
http://localhost:8080/api/employees/new (method POST) -> creates new employee
http://localhost:8080/api/employees/delete/89 (method DELETE) -> deletes employee with id=89
http://localhost:8080/api/employees/update (method PUT) -> updates an employee
*/
}
