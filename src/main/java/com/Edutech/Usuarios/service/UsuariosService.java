package com.Edutech.Usuarios.service;

import com.Edutech.Usuarios.model.Usuarios;
import com.Edutech.Usuarios.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public Usuarios save(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    @Transactional
    public Usuarios updateUser(Long id, Usuarios userUpdateRequest) {
        Usuarios existingUser = usuariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        if (userUpdateRequest.getNombre() != null) {
            existingUser.setNombre(userUpdateRequest.getNombre());
        }
        if (userUpdateRequest.getCorreo() != null) {
            existingUser.setCorreo(userUpdateRequest.getCorreo());
        }

        return usuariosRepository.save(existingUser);
    }

    public Usuarios findById(Long id) {
        return usuariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }
}