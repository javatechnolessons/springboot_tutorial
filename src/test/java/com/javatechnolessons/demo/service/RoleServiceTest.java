package com.javatechnolessons.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import com.javatechnolessons.demo.dto.RoleDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoleServiceTest {
    /**
     *
     */
    private static final String ADMIN = "ADMIN";
    @Autowired
    private RoleServiceImpl roleService;

    @Test
    public void contraintsValidationExceptionTest(){

        assertThrows(ConstraintViolationException.class, ()-> {roleService.save(new RoleDTO(null));});
        assertThrows(ConstraintViolationException.class, ()-> {roleService.save(new RoleDTO(""));});
        assertThrows(ConstraintViolationException.class, ()-> {roleService.save(new RoleDTO("1234567890123456"));});
       
    }

    @Test
    public void saveRoleOk(){
        RoleDTO roleDto = roleService.save(new RoleDTO(ADMIN));
        assertNotNull(roleDto);
        assertEquals(ADMIN, roleDto.getName());
        assertNotNull(roleDto.getId());
    }
}
