package com.javatechnolessons.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.javatechnolessons.demo.dto.RoleDTO;

public interface IRoleService {
    public RoleDTO save(@Valid RoleDTO role);
    public RoleDTO get(Long id);
    public List<RoleDTO> getAll();
    public void delete(Long id);

}
