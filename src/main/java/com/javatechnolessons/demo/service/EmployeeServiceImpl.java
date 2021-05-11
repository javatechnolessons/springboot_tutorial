package com.javatechnolessons.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.javatechnolessons.demo.dto.EmployeeDTO;
import com.javatechnolessons.demo.dto.ProjectDTO;
import com.javatechnolessons.demo.model.Employee;
import com.javatechnolessons.demo.repository.IEmployeeJpaRepository;
import com.javatechnolessons.demo.repository.IProjectJpaRepository;
import com.javatechnolessons.demo.service.exception.EmployeeNotFoundException;
import com.javatechnolessons.demo.service.exception.TechnicalException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        }else{
            employeeEntity = employeeRepo.getOne(employee.getId());
            employeeEntity = modelMapper.map(employee, Employee.class);
        }
        employeeEntity = employeeRepo.save(employeeEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO get(Long id) throws EmployeeNotFoundException, TechnicalException {
        EmployeeDTO employeeDto = null;
        try {
            Employee employeeEntity = employeeRepo.getOne(id);
            employeeEntity.getLastName();
            employeeDto = modelMapper.map(employeeEntity, EmployeeDTO.class);
        } catch (EntityNotFoundException e) {
            throw new EmployeeNotFoundException(id, e);
        } catch (Exception e) {
            throw new TechnicalException(e);
        }
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
    public void delete(Long id) throws EmployeeNotFoundException,TechnicalException {
        try {
            employeeRepo.deleteById(id);
        } 
        catch (EmptyResultDataAccessException e) {
            throw new EmployeeNotFoundException(id, e);
        }       
        catch (Exception e) {
            throw new TechnicalException(e);
        }

    }

}
