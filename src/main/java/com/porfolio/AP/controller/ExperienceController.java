package com.porfolio.AP.controller;

import com.porfolio.AP.dto.EducationDto;
import com.porfolio.AP.dto.ExperienceDto;
import com.porfolio.AP.dto.Mensaje;
import com.porfolio.AP.entity.Education;
import com.porfolio.AP.entity.Experience;
import com.porfolio.AP.service.ExperienceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "https://portfolio-6507f.web.app/")
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list(){
        List<Experience>  list = experienceService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id")int id){
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienceDto experienceDto){
        if(StringUtils.isBlank(experienceDto.getPuesto()))
            return new ResponseEntity<>(new Mensaje("El puesto es obligatorio."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienceDto.getEmpleador()))
            return new ResponseEntity<>(new Mensaje("El empleador de la experiencia laboral es obligatorio."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienceDto.getDescripcion()))
            return new ResponseEntity<>(new Mensaje("La descripción de la experiencia laboral es obligatoria."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienceDto.getImg()))
            return new ResponseEntity<>(new Mensaje("El URL de la imagen es obligatorio."), HttpStatus.BAD_REQUEST);

        if (experienceDto.getInicio()<1950)
            return new ResponseEntity<>(new Mensaje("El año de inicio debe ser mayor a 1950."), HttpStatus.BAD_REQUEST);
        if(experienceDto.getInicio()>2022)
            return new ResponseEntity<>(new Mensaje("El año de inicio no puede ser mayor a 2022."), HttpStatus.BAD_REQUEST);
        if (experienceDto.getFin()<1950)
            return new ResponseEntity<>(new Mensaje("El año de finalización debe ser mayor a 1950."), HttpStatus.BAD_REQUEST);
        if (experienceDto.getFin()>2022)
            return new ResponseEntity<>(new Mensaje("El año de finalización no puede ser mayor a 2022."), HttpStatus.BAD_REQUEST);

        if(experienceService.existsByPuesto(experienceDto.getPuesto()))
            return new ResponseEntity<>(new Mensaje("Ese Puesto ya está registrado."), HttpStatus.BAD_REQUEST);
        Experience experience = new Experience(experienceDto.getPuesto(), experienceDto.getEmpleador(), experienceDto.getDescripcion(), experienceDto.getImg(), experienceDto.getInicio(), experienceDto.getFin());
        experienceService.save(experience);
        return new ResponseEntity<>(new Mensaje("Registro de experiencia laboral agregado exitósamente."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienceDto experienceDto){
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        if(experienceService.existsByPuesto(experienceDto.getPuesto()) && experienceService.getByPuesto(experienceDto.getPuesto()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Ese puesto ya existe."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienceDto.getPuesto()))
            return new ResponseEntity<>(new Mensaje("El puesto es obligatorio."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienceDto.getEmpleador()))
            return new ResponseEntity<>(new Mensaje("El empleador de la experiencia laboral es obligatorio."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienceDto.getDescripcion()))
            return new ResponseEntity<>(new Mensaje("La descripción del puesto es obligatoria."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(experienceDto.getImg()))
            return new ResponseEntity<>(new Mensaje("El URL de la imagen es obligatorio."), HttpStatus.BAD_REQUEST);

        if (experienceDto.getInicio()<1950)
            return new ResponseEntity<>(new Mensaje("El año de inicio debe ser mayor a 1950."), HttpStatus.BAD_REQUEST);
        if(experienceDto.getInicio()>2022)
            return new ResponseEntity<>(new Mensaje("El año de inicio no puede ser mayor a 2022."), HttpStatus.BAD_REQUEST);
        if (experienceDto.getFin()<1950)
            return new ResponseEntity<>(new Mensaje("El año de finalización debe ser mayor a 1950."), HttpStatus.BAD_REQUEST);
        if (experienceDto.getFin()>2022)
            return new ResponseEntity<>(new Mensaje("El año de finalización no puede ser mayor a 2022."), HttpStatus.BAD_REQUEST);

        Experience experience = experienceService.getOne(id).get();
        experience.setPuesto(experienceDto.getPuesto());
        experience.setEmpleador(experienceDto.getEmpleador());
        experience.setDescripcion(experienceDto.getDescripcion());
        experience.setImg(experienceDto.getImg());
        experience.setInicio(experienceDto.getInicio());
        experience.setFin(experienceDto.getFin());

        experienceService.save(experience);
        return new ResponseEntity<>(new Mensaje("Registro actualizado correctamente."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!experienceService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        experienceService.delete(id);
        return new ResponseEntity<>(new Mensaje("Registro eliminado correctamente."), HttpStatus.OK);

    }

}
