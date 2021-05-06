package com.javatechnolessons.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RoleDTO {
    @EqualsAndHashCode.Include
    private String id;

    @NotBlank
    @Size(max = 15)
    private String name;

    public RoleDTO(String id, @NotBlank @Size(max = 15) String name) {
        this.id = id;
        this.name = name;
    }

    

}
