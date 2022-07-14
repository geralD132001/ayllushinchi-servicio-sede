package com.backend.springboot.app.sede.models.service;

import com.backend.springboot.app.commons.sedes.models.entity.Carrera;
import java.util.List;

public interface ICarreraService {
    public List<Carrera> findAll();
    public Carrera findById(Long id);
}
