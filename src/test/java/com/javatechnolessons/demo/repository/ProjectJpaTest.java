package com.javatechnolessons.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityNotFoundException;

import com.javatechnolessons.demo.model.Project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProjectJpaTest {
    @Autowired
    IProjectJpaRepository projRepo;

    @Test
    public void projectTest() {
        Project proj1 = new Project("PROJECT1");
        proj1 = projRepo.save(proj1);
        assertNotNull(proj1);
        assertNotNull(proj1.getId());
        assertEquals("PROJECT1", proj1.getName());
        assertEquals(proj1.getId(), projRepo.findByName("PROJECT1").getId());
    }

    @Test
    public void projectExceptionsTest(){
       Project proj =  projRepo.getOne(Long.valueOf("99"));
       System.out.println(proj.getId());
       assertThrows(EntityNotFoundException.class, ()->{projRepo.getOne(Long.valueOf("99")).getName();});
       assertThrows(EmptyResultDataAccessException.class, ()->{projRepo.deleteById(Long.valueOf("99"));});
    }
}
