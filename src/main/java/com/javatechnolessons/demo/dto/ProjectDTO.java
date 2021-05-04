package com.javatechnolessons.demo.dto;

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
public class ProjectDTO {
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 15)
    private String name;

    public ProjectDTO(String name) {
        this.name = name;
    }
}
