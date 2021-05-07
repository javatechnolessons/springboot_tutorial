package com.javatechnolessons.demo.mvc.controller;

import java.util.HashMap;

import com.javatechnolessons.demo.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
