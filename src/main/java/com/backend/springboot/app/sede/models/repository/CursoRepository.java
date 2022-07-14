package com.backend.springboot.app.sede.models.repository;

import com.backend.springboot.app.commons.sedes.models.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
