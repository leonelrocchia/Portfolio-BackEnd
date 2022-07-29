package com.porfolio.AP.repository;

import com.porfolio.AP.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
    Optional<Education> findByTitulo(String titulo);
    boolean existsByTitulo(String titulo);
}
