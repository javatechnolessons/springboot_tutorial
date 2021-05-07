package com.javatechnolessons.demo.rest.controller;

import java.util.List;

import com.javatechnolessons.demo.dto.RoleDTO;
import com.javatechnolessons.demo.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/all")
    public List<RoleDTO> all(){
        return roleService.getAll();
    }

    @PostMapping("/new")
    RoleDTO newEmployee(@RequestBody RoleDTO newRole) {
      return roleService.save(newRole);
    }
}
