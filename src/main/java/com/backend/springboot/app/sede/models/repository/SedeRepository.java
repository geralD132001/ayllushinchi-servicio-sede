package com.backend.springboot.app.sede.models.repository;

import com.backend.springboot.app.commons.sedes.models.entity.Sede;
import org.springframework.data.repository.CrudRepository;

public interface SedeRepository extends CrudRepository<Sede,Long> {
}
