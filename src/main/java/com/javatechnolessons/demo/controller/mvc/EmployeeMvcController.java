package com.javatechnolessons.demo.controller.mvc;

import java.util.HashMap;
import java.util.List;

import com.javatechnolessons.demo.controller.mvc.form.EmployeeForm;
import com.javatechnolessons.demo.dto.EmployeeDTO;
import com.javatechnolessons.demo.dto.ProjectDTO;
import com.javatechnolessons.demo.dto.RoleDTO;
import com.javatechnolessons.demo.service.IEmployeeService;
import com.javatechnolessons.demo.service.IProjectService;
import com.javatechnolessons.demo.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")

public class EmployeeMvcController {

    @Autowired
    IRoleService roleService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IProjectService projectService;

    @GetMapping(value = "/show")
    public ModelAndView showEmployees() {

        List<EmployeeDTO> employees = employeeService.getAll();
        List<ProjectDTO> projects = projectService.getAll();
        List<RoleDTO> listRoles = roleService.getAll();

        var params = new HashMap<String, Object>();
        params.put("listEmployees", employees);
        params.put("listProjects", projects);
        params.put("listRoles", listRoles);

        return new ModelAndView("employees", params);

    }

    @PostMapping(value = "/save")
    public ModelAndView save(EmployeeForm employeeForm) {
        employeeService.save(employeeForm.getEmployee());
        return new ModelAndView("redirect:/employees/show");
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editEmployee(@ModelAttribute("id") Long id) {

        EmployeeForm form = new EmployeeForm();
        form.setEmployee(employeeService.get(id));
        form.setProjects(projectService.getAll());
        form.setRoles(roleService.getAll());

        var params = new HashMap<String, Object>();

        params.put("form", form);

        return new ModelAndView("employeeForm", params);

    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteEmployee(@ModelAttribute("id") Long id) {
        employeeService.delete(id);
        return new ModelAndView("redirect:/employees/show");
    }

    @GetMapping(value = "/new")
    public ModelAndView newEmployee() {
        EmployeeForm form = new EmployeeForm();
        form.setEmployee(new EmployeeDTO());
        form.setProjects(projectService.getAll());
        form.setRoles(roleService.getAll());

        var params = new HashMap<String, Object>();

        params.put("form", form);

        return new ModelAndView("employeeForm", params);

    }
}
