package com.javatechnolessons.demo.service;

import com.javatechnolessons.demo.exception.BusinessException;
import com.javatechnolessons.demo.exception.TechnicalException;
import com.javatechnolessons.demo.model.Role;
import com.javatechnolessons.demo.repository.IRoleJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Role Service that uses JPA
 * @author javatechnolessons
 * @version 1.0
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleJpaRepository repoRole;

    @Override
    public Role create(String name) throws BusinessException, TechnicalException {
        Role role;
        if (name == null || name.isEmpty() || name.length() > 15) {
            throw new BusinessException("argument name is mandatory, can't be empty and length <=15");
        }
        role = repoRole.findByName(name);
        if (role == null) {
            role = new Role(name);
            try {
                role = repoRole.save(role);
            } catch (Exception e) {
                throw new TechnicalException("A problem occured, please contact admin");
            }

        } else {
            throw new BusinessException("role already exists!");
        }

        return role;
    }

}
