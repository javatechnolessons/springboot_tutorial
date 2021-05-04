package com.javatechnolessons.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.javatechnolessons.demo.dto.EmployeeDTO;
import com.javatechnolessons.demo.model.Employee;
import com.javatechnolessons.demo.repository.IEmployeeJpaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * Employee service that access EmployeeJpaRepository
 * @author javatechnolessons
 * @version 1.0
 */
@Service
@Validated
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeJpaRepository employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDTO save(EmployeeDTO employee) {
        Employee employeeEntity = modelMapper.map(employee, Employee.class);
        employeeEntity = employeeRepo.save(employeeEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO get(Long id) {
        Employee employeeEntity = employeeRepo.getOne(id);
        EmployeeDTO employeeDto = modelMapper.map(employeeEntity, EmployeeDTO.class);
        return employeeDto;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> listEmployeeEntity = employeeRepo.findAll();
        List<EmployeeDTO> listEmployeeDto = listEmployeeEntity.stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
        return listEmployeeDto;
    }

    @Override
    public void delete(Long id) {
        employeeRepo.deleteById(id);

    }

}
