package com.porfolio.AP.controller;

import com.porfolio.AP.dto.ExperienceDto;
import com.porfolio.AP.dto.Mensaje;
import com.porfolio.AP.dto.ProjectDto;
import com.porfolio.AP.entity.Experience;
import com.porfolio.AP.entity.Project;
import com.porfolio.AP.service.ExperienceService;
import com.porfolio.AP.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "https://portfolio-6507f.web.app/")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/list")
    public ResponseEntity<List<Project>> list(){
        List<Project>  list = projectService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id")int id){
        if(!projectService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        Project project = projectService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProjectDto projectDto){
        if(StringUtils.isBlank(projectDto.getProyecto()))
            return new ResponseEntity<>(new Mensaje("El nombre del proyecto es obligatorio."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(projectDto.getDescripcion()))
            return new ResponseEntity<>(new Mensaje("La descripción del proyecto es obligatoria."), HttpStatus.BAD_REQUEST);
        if (projectDto.getYear()<1950)
            return new ResponseEntity<>(new Mensaje("El año del proyecto debe ser mayor a 1950."), HttpStatus.BAD_REQUEST);
        if(projectDto.getYear()>2022)
            return new ResponseEntity<>(new Mensaje("El año del proyecto no puede ser mayor a 2022."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(projectDto.getLink()))
            return new ResponseEntity<>(new Mensaje("El link del proyecto es obligatorio."), HttpStatus.BAD_REQUEST);


        if(projectService.existsByProyecto(projectDto.getProyecto()))
            return new ResponseEntity<>(new Mensaje("Ese Proyecto ya está registrado."), HttpStatus.BAD_REQUEST);
        Project project = new Project(projectDto.getProyecto(), projectDto.getCliente(), projectDto.getDescripcion(), projectDto.getImg(), projectDto.getYear(), projectDto.getLink());
        projectService.save(project);
        return new ResponseEntity<>(new Mensaje("Registro de Proyecto agregado exitósamente."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProjectDto projectDto){
        if(!projectService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        if(projectService.existsByProyecto(projectDto.getProyecto()) && projectService.getByProyecto(projectDto.getProyecto()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Ese proyecto ya existe."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(projectDto.getProyecto()))
            return new ResponseEntity<>(new Mensaje("El nombre del proyecto es obligatorio."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(projectDto.getDescripcion()))
            return new ResponseEntity<>(new Mensaje("La descripción del proyecto es obligatoria."), HttpStatus.BAD_REQUEST);
        if(projectDto.getYear()<1950)
            return new ResponseEntity<>(new Mensaje("El año del proyecto debe ser mayor a 1950."), HttpStatus.BAD_REQUEST);
        if(projectDto.getYear()>2022)
            return new ResponseEntity<>(new Mensaje("El año del proyecto no puede ser mayor a 2022."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(projectDto.getLink()))
            return new ResponseEntity<>(new Mensaje("El link del proyecto es obligatorio."), HttpStatus.BAD_REQUEST);

        Project project = projectService.getOne(id).get();
        project.setProyecto(projectDto.getProyecto());
        project.setCliente(projectDto.getCliente());
        project.setDescripcion(projectDto.getDescripcion());
        project.setImg(projectDto.getImg());
        project.setYear(projectDto.getYear());
        project.setLink(projectDto.getLink());

        projectService.save(project);
        return new ResponseEntity<>(new Mensaje("Registro actualizado correctamente."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!projectService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        projectService.delete(id);
        return new ResponseEntity<>(new Mensaje("Registro eliminado correctamente."), HttpStatus.OK);

    }

}
