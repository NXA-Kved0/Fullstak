package com.inscripcion.inscripcion.controller;
import com.inscripcion.inscripcion.model.Inscripcion;
import com.inscripcion.inscripcion.service.InscripcionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/inscripcion")
@Tag(name = "inscripciones", description = "Inscripcion de estudiantes")

public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    @Operation(summary = "Inscribir estudiantes ", description = "Inscribe estudiantes")
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

    @PutMapping("{id}")
    public Inscripcion actualizarInscripcion (@PathVariable int id, @RequestBody Inscripcion inscripcion){
        return inscripcionService.save(inscripcion);
    }

    @DeleteMapping("{id}")
    public void eliminarInscripcion(@PathVariable int id){
        inscripcionService.delete(id);
    }

}
