package com.inscripcion.inscripcion.service;
import com.inscripcion.inscripcion.model.Inscripcion;
import com.inscripcion.inscripcion.repository.InscripcionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional

public class InscripcionService {

    @Autowired

    private InscripcionRepository incripcionRepository;

    public List <Inscripcion> findAll (){
        return incripcionRepository.findAll();
    }

    public Inscripcion findById (long id){
        return incripcionRepository.findById(id).get();
    }

    public void delete (Long id){
        incripcionRepository.deleteById(id);
    }

    public Inscripcion save (Inscripcion incripcion){
        return incripcionRepository.save(incripcion);
    }
}
