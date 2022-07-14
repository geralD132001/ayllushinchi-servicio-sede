package com.backend.springboot.app.sede.models.service;
import com.backend.springboot.app.commons.sedes.models.entity.Facultad;
import java.util.List;

public interface IFacultadService {
    public List<Facultad> findAll();
    public Facultad findById(Long id);
    public Facultad save(Facultad facultad);
}
