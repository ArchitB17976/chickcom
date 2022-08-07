package com.chickcom.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectControl 
{
    @Autowired
    private ProjectServe pServe;

    @PostMapping("/post/")
    public Project addProject(@RequestBody Project project)
    {
        return pServe.saveProjectToDB(project);
    }

    @GetMapping("/get/{projId}")
    public List<Project> getProjects(@PathVariable (required = false) long projId)
    {
        return pServe.getListOfProjects(projId);
    }

    @PutMapping("/updateEtoP/{projectID}/employee/{empID}")
    public Project assignEmployee(@PathVariable long empID, 
                                  @PathVariable long projectID)
    {
        return pServe.assignEmpTProject(empID, projectID);
    }
}
