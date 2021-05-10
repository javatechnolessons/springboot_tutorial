package com.javatechnolessons.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import com.javatechnolessons.demo.dto.ProjectDTO;
import com.javatechnolessons.demo.model.Project;
import com.javatechnolessons.demo.repository.IProjectJpaRepository;
import com.javatechnolessons.demo.service.exception.ProjectNotFoundException;
import com.javatechnolessons.demo.service.exception.TechnicalException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * Project service that access ProjectJpaRepository
 * 
 * @author javatechnolessons
 * @version 1.0
 */
@Service
@Validated
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectJpaRepository projectRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectDTO save(ProjectDTO project) {
        Project projectEntity = modelMapper.map(project, Project.class);
        projectEntity = projectRepo.save(projectEntity);
        return modelMapper.map(projectEntity, ProjectDTO.class);
    }

    @Override
    public ProjectDTO get(Long id) throws ProjectNotFoundException, TechnicalException {
        ProjectDTO projectDto = null;
        try {
            Project projectEntity = projectRepo.getOne(id);
            modelMapper.map(projectEntity, ProjectDTO.class);
        } catch (EntityNotFoundException e) {
            throw new ProjectNotFoundException(id, e);
        } catch (Exception e) {
            throw new TechnicalException(e);
        }
        return projectDto;
    }

    @Override
    public List<ProjectDTO> getAll() {
        List<Project> listProjectEntity = projectRepo.findAll();
        List<ProjectDTO> listProjectDto = listProjectEntity.stream()
                .map(project -> modelMapper.map(project, ProjectDTO.class)).collect(Collectors.toList());
        return listProjectDto;
    }

    @Override
    public void delete(Long id) throws ProjectNotFoundException,TechnicalException {
        try {
            projectRepo.deleteById(id);
        } 
        catch (EmptyResultDataAccessException e) {
            throw new ProjectNotFoundException(id, e);
        }       
        catch (Exception e) {
            throw new TechnicalException(e);
        }

    }

}
