package com.inscripcion.inscripcion.controller;
import com.inscripcion.inscripcion.model.Inscripcion;
import com.inscripcion.inscripcion.service.InscripcionService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/inscripcion")

public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public ResponseEntity<List<Inscripcion>> listar() {
        List<Inscripcion> inscripcions = inscripcionService.findAll();
        if (inscripcions.isEmpty()) {
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(inscripcions);
    }

    @PostMapping
    public ResponseEntity<Inscripcion> createInscripcion(@RequestBody Inscripcion inscripcion) {
        System.out.println("inscripcion: " + inscripcion);
        Inscripcion nuevo = inscripcionService.save(inscripcion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
}
