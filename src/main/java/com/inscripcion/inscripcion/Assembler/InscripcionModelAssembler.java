package com.inscripcion.inscripcion.Assembler;
import com.inscripcion.inscripcion.model.Inscripcion;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class InscripcionModelAssembler implements RepresentationModelAssembler<Inscripcion, EntityModel<Inscripcion>> {
    @Override
    public EntityModel <Inscripcion> toModel (Inscripcion inscripcion){
        return EntityModel.of(inscripcion,
                //linkTo(methodOn(InscripcionControllerV2.class).getInscripcionesById(inscripcion.getId())).withSelfRel(),
                linkTo(methodOn(InscripcionControllerV2.class).getAllInscripciones()).withRel("Inscripciones"));
    }
}
