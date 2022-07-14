package com.backend.springboot.app.sede.controllers;

import com.backend.springboot.app.commons.sedes.models.entity.Carrera;
import com.backend.springboot.app.commons.sedes.models.entity.Facultad;
import com.backend.springboot.app.sede.models.service.ICarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class CarreraController {

    @Autowired
    private ICarreraService carreraService;

    @GetMapping("/carrera/listar")
    public ResponseEntity<?> listar() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta");
        result.put("data", carreraService.findAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/carrera/ver/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) throws InterruptedException{

        HashMap<String, Object> result = new HashMap<>();
        Carrera data = carreraService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Carrera con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
