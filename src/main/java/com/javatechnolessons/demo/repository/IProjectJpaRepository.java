package com.javatechnolessons.demo.repository;

import java.util.List;

import com.javatechnolessons.demo.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Project JPA Interface
 * 
 * @author javatechnolessons
 * @version 1.0
 */
@Repository
public interface IProjectJpaRepository extends JpaRepository<Project, Long> {
    Project findByName(String name);

    @Query("select p from Project p where p.id in :ids")
    List<Project> findByProjects(@Param("ids") List<Long> ids);
}
