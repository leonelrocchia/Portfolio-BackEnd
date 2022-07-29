package com.porfolio.AP.service;

import com.porfolio.AP.entity.Project;
import com.porfolio.AP.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    //métodos
    public List<Project> list(){
        return projectRepository.findAll();
    }

    public Optional<Project> getOne(int id) {
        return projectRepository.findById(id);
    }

    public Optional<Project> getByProyecto(String proyecto){
        return projectRepository.findByProyecto(proyecto);
    }

    public void save(Project project){
        projectRepository.save(project);
    }

    public void delete(int id){
        projectRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return projectRepository.existsById(id);
    }

    public boolean existsByProyecto(String proyecto){
        return projectRepository.existsByProyecto(proyecto);
    }
}
