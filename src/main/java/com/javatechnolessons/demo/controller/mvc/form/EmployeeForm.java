package com.javatechnolessons.demo.controller.mvc.form;

import java.util.List;

import com.javatechnolessons.demo.dto.EmployeeDTO;
import com.javatechnolessons.demo.dto.ProjectDTO;
import com.javatechnolessons.demo.dto.RoleDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeForm {
    private EmployeeDTO employee;
    private RoleDTO role;
    private List<RoleDTO> roles;
    private List<ProjectDTO> projects;
}
