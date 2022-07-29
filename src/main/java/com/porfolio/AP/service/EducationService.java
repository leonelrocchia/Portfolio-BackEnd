package com.porfolio.AP.service;

import com.porfolio.AP.entity.Education;
import com.porfolio.AP.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducationService {

    @Autowired
    EducationRepository educationRepository;

    //métodos
    public List<Education> list(){
        return educationRepository.findAll();
    }

    public Optional<Education> getOne(int id){
        return educationRepository.findById(id);
    }

    public Optional<Education> getByTitulo(String titulo){
        return educationRepository.findByTitulo(titulo);
    }

    public void save(Education education){
        educationRepository.save(education);
    }

    public void delete(int id){
        educationRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return educationRepository.existsById(id);
    }

    public boolean existsByTitulo(String titulo){
        return educationRepository.existsByTitulo(titulo);
    }


}
