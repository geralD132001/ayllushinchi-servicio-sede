package com.backend.springboot.app.sede.models.service;

import com.backend.springboot.app.sede.models.repository.FacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.backend.springboot.app.commons.sedes.models.entity.Facultad;
import java.util.List;

@Service
public class FacultadServiceImpl implements IFacultadService{

    @Autowired
    private FacultadRepository facultadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Facultad> findAll() {
        return (List<Facultad>) facultadRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Facultad findById(Long id) {
        return facultadRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Facultad save(Facultad facultad) {
        return facultadRepository.save(facultad);
    }
}
