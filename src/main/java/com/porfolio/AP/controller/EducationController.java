package com.porfolio.AP.controller;

import com.porfolio.AP.dto.EducationDto;
import com.porfolio.AP.dto.Mensaje;
import com.porfolio.AP.entity.Education;
import com.porfolio.AP.service.EducationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
@CrossOrigin
public class EducationController {

    @Autowired
    EducationService educationService;

    @GetMapping("/list")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = educationService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!educationService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        Education education = educationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }

   /* @GetMapping("/detail/{titulo}")
    public ResponseEntity<Education> getByTitulo(@PathVariable("titulo") String titulo){
        if(!educationService.existsByTitulo(titulo))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        Education education = educationService.getByTitulo(titulo).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }*/

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducationDto educationDto){
        if(StringUtils.isBlank(educationDto.getTitulo()))
            return new ResponseEntity<>(new Mensaje("El título es obligatorio."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getInstitucion()))
            return new ResponseEntity<>(new Mensaje("El nombre de la Institución educativa es obligatorio."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getDescripcion()))
            return new ResponseEntity<>(new Mensaje("La descripción del título es obligatoria."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getImg()))
            return new ResponseEntity<>(new Mensaje("El URL de la imagen es obligatorio."), HttpStatus.BAD_REQUEST);

        if (educationDto.getInicio()<1950)
            return new ResponseEntity<>(new Mensaje("El año de inicio debe ser mayor a 1950."), HttpStatus.BAD_REQUEST);
        if(educationDto.getInicio()>2022)
            return new ResponseEntity<>(new Mensaje("El año de inicio no puede ser mayor a 2022."), HttpStatus.BAD_REQUEST);
        if (educationDto.getFin()<1950)
            return new ResponseEntity<>(new Mensaje("El año de finalización debe ser mayor a 1950."), HttpStatus.BAD_REQUEST);
        if (educationDto.getFin()>2022)
            return new ResponseEntity<>(new Mensaje("El año de finalización no puede ser mayor a 2022."), HttpStatus.BAD_REQUEST);

        if(educationService.existsByTitulo(educationDto.getTitulo()))
            return new ResponseEntity<>(new Mensaje("Ese título ya existe."), HttpStatus.BAD_REQUEST);
        Education education = new Education(educationDto.getTitulo(), educationDto.getInstitucion(), educationDto.getDescripcion(), educationDto.getImg(), educationDto.getInicio(), educationDto.getFin());
        educationService.save(education);
        return new ResponseEntity<>(new Mensaje("Registro de Educación agregado exitósamente."), HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducationDto educationDto){
        if(!educationService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        if(educationService.existsByTitulo(educationDto.getTitulo()) && educationService.getByTitulo(educationDto.getTitulo()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Ese título ya existe."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getTitulo()))
            return new ResponseEntity<>(new Mensaje("El título es obligatorio."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getInstitucion()))
            return new ResponseEntity<>(new Mensaje("El nombre de la Institución educativa es obligatorio."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getDescripcion()))
            return new ResponseEntity<>(new Mensaje("La descripción del título es obligatoria."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getImg()))
            return new ResponseEntity<>(new Mensaje("El URL de la imagen es obligatorio."), HttpStatus.BAD_REQUEST);

        if (educationDto.getInicio()<1950)
            return new ResponseEntity<>(new Mensaje("El año de inicio debe ser mayor a 1950."), HttpStatus.BAD_REQUEST);
        if(educationDto.getInicio()>2022)
            return new ResponseEntity<>(new Mensaje("El año de inicio no puede ser mayor a 2022."), HttpStatus.BAD_REQUEST);
        if (educationDto.getFin()<1950)
            return new ResponseEntity<>(new Mensaje("El año de finalización debe ser mayor a 1950."), HttpStatus.BAD_REQUEST);
        if (educationDto.getFin()>2022)
            return new ResponseEntity<>(new Mensaje("El año de finalización no puede ser mayor a 2022."), HttpStatus.BAD_REQUEST);

        Education education = educationService.getOne(id).get();
        education.setTitulo(educationDto.getTitulo());
        education.setInstitucion(educationDto.getInstitucion());
        education.setDescripcion(educationDto.getDescripcion());
        education.setImg(educationDto.getImg());
        education.setInicio(educationDto.getInicio());
        education.setFin(educationDto.getFin());

        educationService.save(education);
        return new ResponseEntity<>(new Mensaje("Registro de educación actualizado correctamente."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!educationService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        educationService.delete(id);
        return new ResponseEntity<>(new Mensaje("Registro de educación eliminado correctamente."), HttpStatus.OK);

    }


}
