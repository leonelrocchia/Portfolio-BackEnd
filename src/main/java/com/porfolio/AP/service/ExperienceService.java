package com.porfolio.AP.service;

import com.porfolio.AP.entity.Education;
import com.porfolio.AP.entity.Experience;
import com.porfolio.AP.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    //métodos
    public List<Experience> list(){
        return experienceRepository.findAll();
    }

    public Optional<Experience> getOne(int id) {
        return experienceRepository.findById(id);
    }

    public Optional<Experience> getByPuesto(String puesto){
        return experienceRepository.findByPuesto(puesto);
    }

    public void save(Experience experience){
        experienceRepository.save(experience);
    }

    public void delete(int id){
        experienceRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return experienceRepository.existsById(id);
    }

    public boolean existsByPuesto(String puesto){
        return experienceRepository.existsByPuesto(puesto);
    }

}
