package com.javatechnolessons.demo.service;

import com.javatechnolessons.demo.model.Role;

import java.util.List;
/**
 * Interface Role service
 * @author javatechnolessons
 * @version 2.0
 */
public interface IRoleService {
    Role create(String name);

    void remove(String name);

    void remove(Long id);

    Role get(Long id);

    Role get(String name);

    List<Role> getAll();

    Role update(Long id, Role new_role);

    Role update(String name, Role new_role);
}
