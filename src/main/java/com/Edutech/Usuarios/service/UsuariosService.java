package com.Edutech.Usuarios.service;

import com.Edutech.Usuarios.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Edutech.Usuarios.repository.UsuariosRepository;

import java.util.List;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public Usuarios save(Usuarios usuarios){
        return usuariosRepository.save(usuarios);
    }

    public List <Usuarios> findAll(){
        return usuariosRepository.findAll();
    }
}
