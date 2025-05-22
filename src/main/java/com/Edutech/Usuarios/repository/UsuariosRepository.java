package com.Edutech.Usuarios.repository;

import com.Edutech.Usuarios.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
}
