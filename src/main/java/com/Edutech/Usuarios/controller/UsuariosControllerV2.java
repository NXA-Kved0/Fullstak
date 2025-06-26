package com.Edutech.Usuarios.controller;
import com.Edutech.Usuarios.assemblers.UsuariosModelAssembler;
import com.Edutech.Usuarios.model.Usuarios;
import com.Edutech.Usuarios.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@RestController
@RequestMapping("/api/v2/usuarios")
public class UsuariosControllerV2 {
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private UsuariosModelAssembler assembler;
    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Usuarios>> getAllUsuarios() {
        List<EntityModel<Usuarios>> usuarios = usuariosService.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(usuarios,
                linkTo(methodOn(UsuariosControllerV2.class).getAllUsuarios()).withSelfRel());
    }
    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Usuarios> getUsuariosById(@PathVariable Long id) {
        Usuarios usuarios = usuariosService.findById(id);
        return assembler.toModel(usuarios);
    }
    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Usuarios>> createUsuarios(@RequestBody Usuarios usuarios) {
        Usuarios newUsuarios = usuariosService.save(usuarios);
        return ResponseEntity
                .created(linkTo(methodOn(UsuariosControllerV2.class).getUsuariosById(newUsuarios.getId())).toUri())
                .body(assembler.toModel(newUsuarios));
    }
    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Usuarios>> updateUsuarios(@PathVariable Long id, @RequestBody Usuarios usuarios) {
        usuarios.setId(id);
        Usuarios updatedUsuarios = usuariosService.save(usuarios);
        return ResponseEntity
                .ok(assembler.toModel(updatedUsuarios));
    }
    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> deleteUsuarios(@PathVariable Long id) {
        usuariosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}