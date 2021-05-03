package com.javatechnolessons.demo.service;

import javax.validation.Valid;

import com.javatechnolessons.demo.dto.RoleDto;

public interface IRoleService {
    public RoleDto create(@Valid RoleDto role);
}
