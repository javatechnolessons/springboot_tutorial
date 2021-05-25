package com.javatechnolessons.demo.controller.rest;

import java.util.List;

import com.javatechnolessons.demo.dto.RoleDTO;
import com.javatechnolessons.demo.service.IRoleService;

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
@RequestMapping("/api/roles")
public class RoleRestController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/{id}")
    public RoleDTO getRole(@PathVariable("id") Long id) {
        return roleService.get(id);
    }

    @GetMapping("/all")
    public List<RoleDTO> getAllRoles(){
        return roleService.getAll();
    }

    @PostMapping("/new")
    RoleDTO newRole(@RequestBody RoleDTO newRole) {
      return roleService.save(newRole);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable("id") Long id){
      roleService.delete(id);
    }

    @PutMapping("/update")
    public RoleDTO updateRole(@RequestBody RoleDTO updatedRole){
      return roleService.save(updatedRole);
    }
}
