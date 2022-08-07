package com.chickcom.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.chickcom.project.Project;
import com.chickcom.project.ProjectRepo;

@Service
public class EmployeeServe 
{
    @Autowired
    private EmployeeRepo eRep;
    
    @Autowired
    private ProjectRepo pRep;

    public Employee saveEmployeeToDB(Employee emp)
    {
        return eRep.save(emp);
    }

    public List<Employee> getListOfEmployees(long empId)
    {
        if((Long)empId == null)
            return eRep.findAll(); 

        return Arrays.asList(eRep.findById(empId).orElse(null));
    }

    public Employee assignProjectToEmp(long empID, long projectID)
    {
        Employee emp = eRep.findById(empID).orElse(null);
        if(emp == null) return null;

        Project project = pRep.findById(projectID).orElse(null);
        if (project == null) return null;

        Set<Project> projectSet = emp.getAssignedProjects();

        projectSet.add(project);
        emp.setAssignedProjects(projectSet);
        return eRep.save(emp);
    }
}
