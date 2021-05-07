package com.javatechnolessons.demo.mvc.converter;

import com.javatechnolessons.demo.dto.RoleDTO;
import com.javatechnolessons.demo.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToRoleDTOConverter implements Converter<String, RoleDTO> {

    @Autowired
    IRoleService roleService;

    @Override
    public RoleDTO convert(String id) {
        RoleDTO role = roleService.get(Long.valueOf(id));
        return role;
    }

}
