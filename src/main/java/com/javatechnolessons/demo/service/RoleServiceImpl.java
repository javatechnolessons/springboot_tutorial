package com.javatechnolessons.demo.service;

import java.util.List;

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
    public List<Role> getAll() {
        return repoRole.findAll();
    }

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

    @Override
    public void remove(String name) {
        // TODO Auto-generated method stub
    }

    @Override
    public void remove(Long id) throws BusinessException, TechnicalException{
        repoRole.deleteById(id);
        
    }

    @Override
    public Role get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Role get(String name) {
        return null;
    }

    @Override
    public Role update(Long id, Role new_role) {
        return repoRole.save(new_role);
    }

    @Override
    public Role update(String name, Role new_role) {
        // TODO Auto-generated method stub
        return null;
    }

}
