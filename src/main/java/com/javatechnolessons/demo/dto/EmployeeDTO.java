package com.javatechnolessons.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmployeeDTO {
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank
    @Size(max = 10)
    private String employeeid;
    @NotBlank
    @Size(max = 25)
    private String firstName;
    @NotBlank
    @Size(max = 25)
    private String lastName;
    @NotNull
    private RoleDTO role;
    private List<ProjectDTO> projects = new ArrayList<ProjectDTO>();
    public EmployeeDTO(String firstName, String lastName, String employeeid, RoleDTO role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeid = employeeid;
        this.role = role;
    }

    
}
