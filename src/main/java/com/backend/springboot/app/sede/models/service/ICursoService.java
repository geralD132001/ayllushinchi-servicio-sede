package com.backend.springboot.app.sede.models.service;

import com.backend.springboot.app.commons.sedes.models.entity.Curso;

import java.util.List;

public interface ICursoService {
    public List<Curso> findAll();
    public Curso findById(Long id);
}
