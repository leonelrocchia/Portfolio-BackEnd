package com.porfolio.AP.service;

import com.porfolio.AP.entity.Skill;
import com.porfolio.AP.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillService {
    @Autowired
    SkillRepository skillRepository;

    //métodos
    public List<Skill> list(){
        return skillRepository.findAll();
    }

    public Optional<Skill> getOne(int id){
        return skillRepository.findById(id);
    }

    public Optional<Skill> getBySkill(String skill){
        return skillRepository.findBySkill(skill);
    }

    public void save(Skill skill){
        skillRepository.save(skill);
    }

    public void delete(int id){
        skillRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return skillRepository.existsById(id);
    }

    public boolean existsBySkill(String skill){
        return skillRepository.existsBySkill(skill);
    }

}
