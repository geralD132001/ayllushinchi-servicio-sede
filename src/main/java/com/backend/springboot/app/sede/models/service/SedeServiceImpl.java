package com.backend.springboot.app.sede.models.service;

import com.backend.springboot.app.commons.sedes.models.entity.Sede;
import com.backend.springboot.app.sede.models.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SedeServiceImpl implements ISedeService{

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Sede> findAll() {
        return (List<Sede>) sedeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Sede findById(Long id) {
        return sedeRepository.findById(id).orElse(null);
    }
}
