package com.Edutech.Usuarios.assemblers;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.Edutech.Usuarios.controller.UsuariosControllerV2;
import com.Edutech.Usuarios.model.Usuarios;
import com.Edutech.Usuarios.model.Usuarios;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
@Component
public class UsuariosModelAssembler implements RepresentationModelAssembler<Usuarios, EntityModel<Usuarios>> {
    @Override
    public EntityModel<Usuarios> toModel(Usuarios usuarios) {
        return EntityModel.of(usuarios,
                linkTo(methodOn(UsuariosControllerV2.class).getUsuariosById(usuarios.getId())).withSelfRel(),
                linkTo(methodOn(UsuariosControllerV2.class).getAllUsuarios()).withRel("usuarios"));
    }
}