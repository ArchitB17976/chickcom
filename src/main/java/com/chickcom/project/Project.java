package com.chickcom.project;

import java.util.*;
import lombok.*;
import javax.persistence.*;
import javax.transaction.Transactional;

import com.chickcom.employee.Employee;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
@Transactional

public class Project 
{
    @Id
    @SequenceGenerator(name = "pro_seq", initialValue = 31010, allocationSize = 1)
    @GeneratedValue(generator = "pro_seq", strategy = GenerationType.SEQUENCE)
    private long id;
    
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY, 
                cascade = CascadeType.ALL, 
                mappedBy = "assignedProjects")
    private Set<Employee> assignedEmployees = new HashSet<>();
}
