package com.javatechnolessons.demo;

import com.javatechnolessons.demo.mvc.converter.StringToProjectDTOConverter;
import com.javatechnolessons.demo.mvc.converter.StringToRoleDTOConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    StringToProjectDTOConverter stringToProjectDTOConverter;

    @Autowired
    StringToRoleDTOConverter stringToRoleDTOConverter;
}
