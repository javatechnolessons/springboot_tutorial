package com.javatechnolessons.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.javatechnolessons.demo.dto.EmployeeDTO;

public interface IEmployeeService {
    public EmployeeDTO save(@Valid EmployeeDTO project);
    public EmployeeDTO get(Long id);
    public List<EmployeeDTO> getAll();
    public void delete(Long id);

}
