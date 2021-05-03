package com.javatechnolessons.demo.service;

import com.javatechnolessons.demo.dto.RoleDto;
import com.javatechnolessons.demo.model.Role;
import com.javatechnolessons.demo.repository.IRoleJpaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleJpaRepository roleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RoleDto create(RoleDto role) {
        Role roleEntity = modelMapper.map(role, Role.class);
        roleEntity = roleRepo.save(roleEntity);
        return modelMapper.map(roleEntity, RoleDto.class);
    }

}
