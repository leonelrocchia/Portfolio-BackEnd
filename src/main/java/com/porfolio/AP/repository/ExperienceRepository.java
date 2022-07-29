package com.porfolio.AP.repository;

import com.porfolio.AP.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    Optional<Experience> findByPuesto(String puesto);

    boolean existsByPuesto(String puesto);
}
