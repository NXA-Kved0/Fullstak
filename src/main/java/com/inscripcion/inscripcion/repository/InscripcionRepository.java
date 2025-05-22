package com.inscripcion.inscripcion.repository;
import com.inscripcion.inscripcion.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository


public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}
