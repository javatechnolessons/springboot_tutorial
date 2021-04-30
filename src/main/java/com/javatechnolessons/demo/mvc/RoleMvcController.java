package com.javatechnolessons.demo.mvc;

import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;

import com.javatechnolessons.demo.exception.BusinessException;
import com.javatechnolessons.demo.exception.TechnicalException;
import com.javatechnolessons.demo.model.Role;
import com.javatechnolessons.demo.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleMvcController {
    // http://locahost:8080/showRoles
    @Autowired
    IRoleService roleService;

    @GetMapping(value = "showRoles")
    public ModelAndView showRoles() {
        List<Role> listRoles = roleService.getAll();

        var params = new HashMap<String, Object>();
        params.put("listRoles", listRoles);

        return new ModelAndView("roles", params);

    }

    @PostMapping(value = "/createRole")
    public ModelAndView createRole(@PathParam("name") String name) {

        var params = new HashMap<String, Object>();

        try {
            roleService.create(name);
        } catch (BusinessException e) {
            params.put("error", e.getMessage());
        }
        catch (TechnicalException e) {
            params.put("error", e.getMessage());
        }
        

        List<Role> listRoles = roleService.getAll();
        params.put("listRoles", listRoles);
        

        return new ModelAndView("roles", params);

    }
}
