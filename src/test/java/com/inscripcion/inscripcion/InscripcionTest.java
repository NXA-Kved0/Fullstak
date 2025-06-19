package com.inscripcion.inscripcion;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.inscripcion.inscripcion.model.Inscripcion;
import com.inscripcion.inscripcion.repository.InscripcionRepository;
import com.inscripcion.inscripcion.service.InscripcionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class InscripcionTest {

    @Autowired
    private InscripcionService inscripcionService;

    @MockitoBean
    private InscripcionRepository inscripcionRepository;

    private Inscripcion inscripcion;

    @BeforeEach
    void setUp(){
        inscripcion = new Inscripcion(1, "1-9", "Ignacia", "Cavedo", new Date(), new Date(), "Alumno@gmail.com", "mi mamá");
    }

    @Test
    public void testFindAll() {

        when(inscripcionRepository.findAll()).thenReturn(List.of(inscripcion));

        List<Inscripcion> inscripciones = inscripcionService.findAll();


        assertNotNull(inscripciones);
        assertEquals(1, inscripciones.size());
    }

    @Test
    public void testFindById() {
        Integer id = 1;

        when(inscripcionRepository.findById(id)).thenReturn(Optional.of(inscripcion));

        Inscripcion found = inscripcionService.findById(id);


        assertNotNull(found);
        assertEquals(id, found.getId());
    }

    @Test
    public void testSave() {


        when(inscripcionRepository.save(inscripcion)).thenReturn(inscripcion);

        Inscripcion saved = inscripcionService.save(inscripcion);

        assertNotNull(saved);
        assertEquals("Ignacia", saved.getNombre());
    }

    @Test
    public void testDeleteById() {
        Integer id = 1;

        doNothing().when(inscripcionRepository).deleteById(id);

        inscripcionService.delete(id);

        verify(inscripcionRepository, times(1)).deleteById(id);
    }
}
