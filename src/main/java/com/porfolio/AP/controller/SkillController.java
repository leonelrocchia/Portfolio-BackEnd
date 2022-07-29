package com.porfolio.AP.controller;

import com.porfolio.AP.dto.Mensaje;
import com.porfolio.AP.dto.SkillDto;
import com.porfolio.AP.entity.Skill;
import com.porfolio.AP.service.SkillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {

    @Autowired
    SkillService skillService;


    @GetMapping("/list")
    public ResponseEntity<List<Skill>> list(){
        List<Skill>  list = skillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id")int id){
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        Skill skill = skillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillDto skillDto){
        if(StringUtils.isBlank(skillDto.getSkill()))
            return new ResponseEntity<>(new Mensaje("El nombre de la skill es obligatorio."), HttpStatus.BAD_REQUEST);
        if (skillDto.getNivel()<1)
            return new ResponseEntity<>(new Mensaje("El nivel de la skill debe ser mayor a 1."), HttpStatus.BAD_REQUEST);
        if(skillDto.getNivel()>100)
            return new ResponseEntity<>(new Mensaje("El nivel de la skill debe ser menor a 100."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(skillDto.getImg()))
            return new ResponseEntity<>(new Mensaje("El URL de la imagen es obligatorio."), HttpStatus.BAD_REQUEST);
        if(skillService.existsBySkill(skillDto.getSkill()))
            return new ResponseEntity<>(new Mensaje("Ese Skill ya está registrado."), HttpStatus.BAD_REQUEST);
        Skill skill = new Skill(skillDto.getSkill(), skillDto.getNivel(), skillDto.getImg());
        skillService.save(skill);
        return new ResponseEntity<>(new Mensaje("Registro de skill agregado exitósamente."), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillDto skillDto){
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        if(skillService.existsBySkill(skillDto.getSkill()) && skillService.getBySkill(skillDto.getSkill()).get().getId() != id)
            return new ResponseEntity<>(new Mensaje("Ese Skill ya existe."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(skillDto.getSkill()))
            return new ResponseEntity<>(new Mensaje("El nombre de la skill es obligatorio."), HttpStatus.BAD_REQUEST);
        if (skillDto.getNivel()<1)
            return new ResponseEntity<>(new Mensaje("El nivel de la skill debe ser mayor a 1."), HttpStatus.BAD_REQUEST);
        if(skillDto.getNivel()>100)
            return new ResponseEntity<>(new Mensaje("El nivel de la skill debe ser menor a 100."), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(skillDto.getImg()))
            return new ResponseEntity<>(new Mensaje("El URL de la imagen es obligatorio."), HttpStatus.BAD_REQUEST);

        Skill skill = skillService.getOne(id).get();
        skill.setSkill(skillDto.getSkill());
        skill.setNivel(skillDto.getNivel());
        skill.setImg(skillDto.getImg());
        skillService.save(skill);
        return new ResponseEntity<>(new Mensaje("Registro actualizado correctamente."), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        skillService.delete(id);
        return new ResponseEntity<>(new Mensaje("Registro eliminado correctamente."), HttpStatus.OK);

    }
}
