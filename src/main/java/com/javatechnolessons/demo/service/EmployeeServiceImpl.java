package com.javatechnolessons.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.javatechnolessons.demo.dto.EmployeeDTO;
import com.javatechnolessons.demo.dto.ProjectDTO;
import com.javatechnolessons.demo.model.Employee;
import com.javatechnolessons.demo.model.Project;
import com.javatechnolessons.demo.repository.IEmployeeJpaRepository;
import com.javatechnolessons.demo.repository.IProjectJpaRepository;

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
    private IProjectJpaRepository projectRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDTO save(EmployeeDTO employee) {
        Employee employeeEntity = modelMapper.map(employee, Employee.class);

        if(employee.getId() == null){
            List<Long> ids = new ArrayList<Long>();
            for(ProjectDTO project:employee.getProjects()){
                ids.add(project.getId());
            }
            employeeEntity.setProjects(projectRepo.findByProjects(ids));
        }
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
