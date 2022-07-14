package com.backend.springboot.app.sede.models.service;

import com.backend.springboot.app.commons.sedes.models.entity.Sede;

import java.util.List;

public interface ISedeService {
    public List<Sede> findAll();
    public Sede findById(Long id);
}
