package com.javatechnolessons.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.javatechnolessons.demo.dto.RoleDTO;
import com.javatechnolessons.demo.model.Role;
import com.javatechnolessons.demo.repository.IRoleJpaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * Role service that access RoleJpaRepository
 * @author javatechnolessons
 * @version 1.0
 */
@Service
@Validated
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleJpaRepository roleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RoleDTO save(RoleDTO role) {
        Role roleEntity = modelMapper.map(role, Role.class);
        roleEntity = roleRepo.save(roleEntity);
        return modelMapper.map(roleEntity, RoleDTO.class);
    }

    @Override
    public RoleDTO get(Long id) {
        Role roleEntity = roleRepo.getOne(id);
        RoleDTO roleDto = modelMapper.map(roleEntity, RoleDTO.class);
        return roleDto;
    }

    @Override
    public List<RoleDTO> getAll() {
        List<Role> listRoleEntity = roleRepo.findAll();
        List<RoleDTO> listRoleDto = listRoleEntity.stream().map(role -> modelMapper.map(role, RoleDTO.class))
                .collect(Collectors.toList());
        return listRoleDto;
    }

    @Override
    public void delete(Long id) {
        roleRepo.deleteById(id);

    }

}
