package com.javatechnolessons.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
