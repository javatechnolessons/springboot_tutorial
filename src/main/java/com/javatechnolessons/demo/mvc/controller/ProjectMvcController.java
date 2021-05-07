package com.javatechnolessons.demo.mvc.controller;

import java.util.HashMap;
import java.util.List;

import com.javatechnolessons.demo.dto.ProjectDTO;
import com.javatechnolessons.demo.mvc.form.ProjectForm;
import com.javatechnolessons.demo.service.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/projects")

public class ProjectMvcController {

    @Autowired
    IProjectService projectService;

    @GetMapping(value = "/show")
    public ModelAndView showProjects() {
        List<ProjectDTO> projects = projectService.getAll();
        var params = new HashMap<String, Object>();
        params.put("listProjects", projects);
        return new ModelAndView("projects", params);
    }

    @PostMapping(value = "/save")
    public ModelAndView save(ProjectForm projectForm) {
        projectService.save(projectForm.getProject());
        return new ModelAndView("redirect:/projects/show");
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editProject(@ModelAttribute("id") Long id) {
        ProjectForm form = new ProjectForm();
        form.setProject(projectService.get(id));    
        var params = new HashMap<String, Object>();
        params.put("form", form);
        return new ModelAndView("projectForm", params);
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteProject(@ModelAttribute("id") Long id) {    
        projectService.delete(id);         
        return new ModelAndView("redirect:/projects/show");
    }

    @GetMapping(value = "/new")
    public ModelAndView newProject() {
        ProjectForm form = new ProjectForm();
        form.setProject(new ProjectDTO());
        var params = new HashMap<String, Object>();
        params.put("form", form);
        return new ModelAndView("projectForm", params);
    }
}
