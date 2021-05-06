package com.javatechnolessons.demo.mvc.converter;

import com.javatechnolessons.demo.dto.ProjectDTO;
import com.javatechnolessons.demo.service.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToProjectDTOConverter implements Converter<String,ProjectDTO> {

    @Autowired
    IProjectService projectService;

    @Override
    public ProjectDTO convert(String id) {
        ProjectDTO projectDTO = projectService.get(Long.valueOf(id));
        return projectDTO;
    }

}
