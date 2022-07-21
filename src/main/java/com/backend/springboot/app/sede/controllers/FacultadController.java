package com.backend.springboot.app.sede.controllers;

import com.backend.springboot.app.commons.sedes.models.entity.Facultad;
import com.backend.springboot.app.sede.models.service.IFacultadService;
import com.backend.springboot.app.sede.models.service.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = { "https://ayllusinchis-app.azurewebsites.net" })
@RestController
public class FacultadController {


    @Autowired
    private IUploadFileService uploadService;

    // @Autowired
    // private IUploadFileServiceDos uploadService2;

    @Autowired
    private IFacultadService facultadService;

    @GetMapping("/facultad/listar")
    public ResponseEntity<?> listar() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta");
        result.put("data", facultadService.findAll());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/facultad/ver/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) throws InterruptedException{

        HashMap<String, Object> result = new HashMap<>();
        Facultad data = facultadService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Facultad con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        result.put("success", true);
        result.put("message", "Se ha encontrado el registro.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("idFacultad") Long idFacultad){
        Map<String, Object> response = new HashMap<>();

        Facultad facultad = facultadService.findById(idFacultad);
        System.out.println(facultad.getIdFacultad()+ "Prueba");

        if(!archivo.isEmpty()) {

            String nombreArchivo = null;
            try {
                nombreArchivo = uploadService.copiar(archivo);
            } catch (IOException e) {
                response.put("mensaje", "Error al subir la imagen del coordinador");
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String nombreFotoAnterior = facultad.getFotoFacultad();

            uploadService.eliminar(nombreFotoAnterior);

            facultad.setFotoFacultad(nombreArchivo);

            facultadService.save(facultad);

            System.out.println(facultad+"Segunda prueba");
            response.put("facultad", facultad);
            response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);

        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){

        Resource recurso = null;

        try {
            recurso = uploadService.cargar(nombreFoto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

        return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
    }


    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<?> crear(@RequestBody Facultad facultad) {
        HashMap<String, Object> result = new HashMap<>();
        Facultad data = facultadService.save(facultad);

        result.put("success", true);
        result.put("message", "La facultad se ha registrado correctamente.");
        result.put("data", facultad);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /*
    @PostMapping("/facultad/img/upload")
    public ResponseEntity<?> upload2(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
        Map<String, Object> response = new HashMap<>();

        Facultad facultad = facultadService.findById(id);

        if(!archivo.isEmpty()) {

            String nombreArchivo = null;
            try {
                nombreArchivo = uploadService2.copiar(archivo);
            } catch (IOException e) {
                response.put("mensaje", "Error al subir la imagen de la facultad");
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String nombreFotoAnterior = facultad.getFotoFacultad();

            uploadService2.eliminar(nombreFotoAnterior);

            facultad.setFotoFacultad(nombreArchivo);

            facultadService.save(facultad);

            response.put("facultad", facultad);
            response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);

        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/uploads/facultad/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto2(@PathVariable String nombreFoto){

        Resource recurso = null;

        try {
            recurso = uploadService2.cargar(nombreFoto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

        return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
    }

     */

}
