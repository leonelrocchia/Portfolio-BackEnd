package com.porfolio.AP.repository;

import com.porfolio.AP.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    Optional<Project> findByProyecto(String proyecto);

    boolean existsByProyecto(String proyecto);

}
