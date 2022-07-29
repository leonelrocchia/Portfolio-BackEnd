package com.porfolio.AP.repository;


import com.porfolio.AP.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    Optional<Skill> findBySkill(String skill);

    boolean existsBySkill(String skill);
}
