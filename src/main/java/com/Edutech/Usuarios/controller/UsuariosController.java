package com.Edutech.Usuarios.controller;

import com.Edutech.Usuarios.service.UsuariosService;
import com.Edutech.Usuarios.model.Usuarios;
import com.Edutech.Usuarios.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        return usuariosService.findAll();
    }

    @PostMapping
    public ResponseEntity createUsuarios(@RequestBody Usuarios usuarios) {
        System.out.println("usuarios: "+usuarios);
        Usuarios nuevo = usuariosService.save(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }


}