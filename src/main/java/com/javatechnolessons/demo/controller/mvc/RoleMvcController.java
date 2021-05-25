package com.javatechnolessons.demo.controller.mvc;

import java.util.HashMap;

import com.javatechnolessons.demo.controller.mvc.form.RoleForm;
import com.javatechnolessons.demo.dto.RoleDTO;
import com.javatechnolessons.demo.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/roles")
public class RoleMvcController {

    @Autowired
    IRoleService roleService;

    @GetMapping("/show")
    public ModelAndView show() {
        var params = new HashMap<String, Object>();
        params.put("listRoles", roleService.getAll());
        return new ModelAndView("roles", params);
    }

    @GetMapping("/new")
    public ModelAndView newRole() {
        var params = new HashMap<String, Object>();
        RoleForm form = new RoleForm();
        form.setRole(new RoleDTO());
        params.put("form", form);
        return new ModelAndView("roleForm", params);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute("id") Long id) {
        var params = new HashMap<String, Object>();
        RoleForm form = new RoleForm();
        form.setRole(roleService.get(id));
        params.put("form", form);
        return new ModelAndView("roleForm", params);
    }

    @PostMapping("/save")
    public ModelAndView save(RoleForm form) {
        roleService.save(form.getRole());
        return new ModelAndView("redirect:/roles/show");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@ModelAttribute("id") Long id) {
        roleService.delete(id);
        return new ModelAndView("redirect:/roles/show");
    }
}
