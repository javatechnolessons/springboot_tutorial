package com.javatechnolessons.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProjectDTO implements Serializable{
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 15)
    private String name;

    public ProjectDTO(String id){
        this.id= Long.valueOf(id);
    }
}
