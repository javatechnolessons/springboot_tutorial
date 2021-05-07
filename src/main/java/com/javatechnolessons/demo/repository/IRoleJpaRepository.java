package com.javatechnolessons.demo.repository;

import java.util.List;

import com.javatechnolessons.demo.model.Role;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Role JPA Interface
 * @author javatechnolessons
 * @version 1.0
 */
@Repository
public interface IRoleJpaRepository extends JpaRepository<Role,Long>{
    Role findByName(String name);
    @Cacheable(value = "roles")
    List<Role> findAll();

}
