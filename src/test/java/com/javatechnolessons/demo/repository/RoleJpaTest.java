package com.javatechnolessons.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.javatechnolessons.demo.model.Role;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RoleJpaTest {
    @Autowired
    IRoleJpaRepository roleRepo;

    @Test
    public void roleTest() {
        Role admin = new Role("ROLE_ADMIN");
        admin = roleRepo.save(admin);
        assertNotNull(admin);
        assertNotNull(admin.getId());
        assertEquals("ROLE_ADMIN", admin.getName());
        assertEquals(admin.getId(), roleRepo.findByName("ROLE_ADMIN").getId());
    }
}
