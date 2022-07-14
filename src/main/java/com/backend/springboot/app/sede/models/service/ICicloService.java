package com.backend.springboot.app.sede.models.service;

import com.backend.springboot.app.commons.sedes.models.entity.Ciclo;
import java.util.List;

public interface ICicloService {
    public List<Ciclo> findAll();
    public Ciclo findById(Long id);
}
