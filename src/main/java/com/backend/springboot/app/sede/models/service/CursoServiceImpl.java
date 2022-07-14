package com.backend.springboot.app.sede.models.service;

import com.backend.springboot.app.commons.sedes.models.entity.Curso;
import com.backend.springboot.app.commons.sedes.models.entity.Facultad;
import com.backend.springboot.app.sede.models.repository.CursoRepository;
import com.backend.springboot.app.sede.models.repository.FacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return (List<Curso>) cursoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }
}
