package com.backend.springboot.app.sede.models.service;

import com.backend.springboot.app.sede.models.repository.CicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.backend.springboot.app.commons.sedes.models.entity.Ciclo;
import java.util.List;

@Service
public class CicloServiceImpl implements ICicloService{

    @Autowired
    private CicloRepository cicloRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Ciclo> findAll() {
        return (List<Ciclo>) cicloRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ciclo findById(Long id) {
        return cicloRepository.findById(id).orElse(null);
    }
}
