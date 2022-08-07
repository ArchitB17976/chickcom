package com.chickcom.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class EmployeeControl 
{
    @Autowired
    private EmployeeServe eServe;
    
    @PostMapping("/post")
    public Employee addEmployee(@RequestBody Employee emp)
    {
        return eServe.saveEmployeeToDB(emp);
    }

    @GetMapping(value = {"/getEmps", "{empID}"})
    public List<Employee> getEmployees(@PathVariable (required = false) long empID)
    {
        return eServe.getListOfEmployees(empID);
    }

    @PutMapping("/updatePtoE/{empID}/project/{projectID}")
    public Employee assignProject(@PathVariable long empID, 
                                  @PathVariable long projectID)
    {
        return eServe.assignProjectToEmp(empID, projectID);
    }
}
