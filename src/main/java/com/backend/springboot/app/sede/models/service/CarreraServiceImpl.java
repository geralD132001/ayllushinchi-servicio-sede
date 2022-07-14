package com.backend.springboot.app.sede.models.service;

import com.backend.springboot.app.sede.models.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.backend.springboot.app.commons.sedes.models.entity.Carrera;
import java.util.List;

@Service
public class CarreraServiceImpl implements ICarreraService{

    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Carrera> findAll() {
        return (List<Carrera>) carreraRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Carrera findById(Long id) {
        return carreraRepository.findById(id).orElse(null);

    }
}
