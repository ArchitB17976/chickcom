package com.chickcom.employee;

import java.util.*;
import javax.persistence.*;
import javax.transaction.Transactional;
import lombok.*;

import com.chickcom.project.Project;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_details")
@Transactional

public class Employee 
{
    @Id
    @SequenceGenerator(name = "emp_seq", initialValue = 11000, allocationSize = 1)
    @GeneratedValue(generator = "emp_seq", strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_projects",
               joinColumns = @JoinColumn(name = "employee_id"),
               inverseJoinColumns = @JoinColumn(name = "project_id"))
        
    private Set<Project> assignedProjects = new HashSet<>();
}
