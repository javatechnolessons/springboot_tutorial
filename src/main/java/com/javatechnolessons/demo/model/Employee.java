package com.javatechnolessons.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents an employee entity
 * 
 * @author javatechnolessons
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 25, nullable = false)
    private String firstName;

    @Column(length = 25, nullable = false)
    private String lastName;

    @Column(length = 10, nullable = false, unique = true)
    private String employeeid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToMany()
    @JoinTable(name = "employee_project", joinColumns = { @JoinColumn(name = "employee_id") }, inverseJoinColumns = {
            @JoinColumn(name = "project_id") })
    private List<Project> projects = new ArrayList<Project>();

    public Employee(String firstName, String lastName, String employeeid, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeid = employeeid;
        this.role = role;
    }
}
