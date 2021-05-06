package com.javatechnolessons.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import com.javatechnolessons.demo.dto.ProjectDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProjectServiceTest {
    /**
     *
     */
    private static final String PROJECT1 = "PROJECT1";
    @Autowired
    private ProjectServiceImpl projectService;

    @Test
    public void contraintsValidationExceptionTest(){

        // assertThrows(ConstraintViolationException.class, ()-> {projectService.save(new ProjectDTO(null));});
        // assertThrows(ConstraintViolationException.class, ()-> {projectService.save(new ProjectDTO(""));});
        // assertThrows(ConstraintViolationException.class, ()-> {projectService.save(new ProjectDTO("1234567890123456"));});
       
    }

    @Test
    public void saveProjectOk(){
/*         ProjectDTO projectDto = projectService.save(new ProjectDTO(PROJECT1));
        assertNotNull(projectDto);
        assertEquals(PROJECT1, projectDto.getName());
        assertNotNull(projectDto.getId()); */
    }
}
