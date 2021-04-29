package com.javatechnolessons.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.javatechnolessons.demo.exception.BusinessException;
import com.javatechnolessons.demo.exception.TechnicalException;
import com.javatechnolessons.demo.model.Role;
import com.javatechnolessons.demo.repository.IRoleJpaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * tests for RoleServiceImpl
 * 
 * @author javatechnolessons
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class RoleServiceTest {

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    @MockBean
    private IRoleJpaRepository roleRepo;
    @InjectMocks
    private RoleServiceImpl roleService;

    @Test
    public void businessExceptionTest() {
        assertThrows(BusinessException.class, () -> {
            roleService.create(null);
        });
        assertThrows(BusinessException.class, () -> {
            roleService.create("");
        });
        assertThrows(BusinessException.class, () -> {
            roleService.create("1234567890123456");
        });

        Mockito.when(roleRepo.findByName(ROLE_ADMIN)).thenReturn(new Role(ROLE_ADMIN));
        assertThrows(BusinessException.class, () -> {
            roleService.create(ROLE_ADMIN);
        });
    }

    @Test
    public void technicalExceptionTest() {
        Mockito.when(roleRepo.findByName(ROLE_ADMIN)).thenReturn(null);
        Mockito.when(roleRepo.save(new Role(ROLE_ADMIN))).thenThrow(new RuntimeException("ERROR"));
        assertThrows(TechnicalException.class, () -> {
            roleService.create(ROLE_ADMIN);
        });
    }

    @Test
    public void createOkTest() {
        Mockito.when(roleRepo.findByName(ROLE_ADMIN)).thenReturn(null);
        Mockito.when(roleRepo.save(new Role(ROLE_ADMIN))).thenReturn(new Role(ROLE_ADMIN));

        assertEquals(new Role(ROLE_ADMIN), roleService.create(ROLE_ADMIN));
    }

}
