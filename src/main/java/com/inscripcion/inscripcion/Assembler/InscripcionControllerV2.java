package com.inscripcion.inscripcion.Assembler;
import com.inscripcion.inscripcion.model.Inscripcion;
import com.inscripcion.inscripcion.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/inscripciones")
public class InscripcionControllerV2 {
    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private InscripcionModelAssembler assembler;

    @GetMapping (produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel <EntityModel<Inscripcion>> getAllInscripciones(){
        List<EntityModel<Inscripcion>> inscripcion =inscripcionService.findAll().stream()
                .map(assembler :: toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(inscripcion,linkTo(methodOn(InscripcionControllerV2.class).getAllInscripciones()).withSelfRel());
    }
}



