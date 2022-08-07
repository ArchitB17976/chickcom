package com.chickcom.project;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chickcom.employee.Employee;
import com.chickcom.employee.EmployeeRepo;

@Service
public class ProjectServe 
{
    @Autowired
    private ProjectRepo pRep;

    @Autowired
    private EmployeeRepo eRep;

    public Project saveProjectToDB(Project project)
    {
        return pRep.save(project);
    }

    public List<Project> getListOfProjects(long projectID)
    {
        if((Long)projectID == null)
            return pRep.findAll();
        
        return Arrays.asList(pRep.findById(projectID).orElse(null));
    }

    public Project assignEmpTProject(long empID, long projectID)
    {
        Project project = pRep.findById(projectID).orElse(null);
        if(project == null) return null;

        Employee emp = eRep.findById(empID).orElse(null);
        if(emp == null) return null;

        Set<Employee> empSet = project.getAssignedEmployees();
        
        empSet.add(emp);
        project.setAssignedEmployees(empSet);
        return pRep.save(project);
    }
}
