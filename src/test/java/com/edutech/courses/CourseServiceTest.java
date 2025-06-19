package com.edutech.courses;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.edutech.courses.model.Course;
import com.edutech.courses.repository.CourseRepository;
import com.edutech.courses.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CourseServiceTest {

    // Inyecta el servicio de Carrera para ser probado.
    @Autowired
    private CourseService courseService;

    // Crea un mock del repositorio de Carrera para simular su comportamiento.
    @MockitoBean
    private CourseRepository courseRepository;

    private Course curso;

    @BeforeEach
    void setUp(){
        curso = new Course(1L, "geometria", "cursodegeometria","lopez", 20000.0);
    }

    @Test
    public void testFindAll() {
        // Define el comportamiento del mock: cuando se llame a findAll(), devuelve una lista con una Carrera.
        when(courseRepository.findAll()).thenReturn(List.of(curso));

        // Llama al método findAll() del servicio.
        List<Course> courses = courseService.findAll();

        // Verifica que la lista devuelta no sea nula y contenga exactamente una Carrera.
        assertNotNull(courses);
        assertEquals(1, courses.size());
    }

    @Test
    public void testFindById() {
        Long id = 1L;

        // Define el comportamiento del mock: cuando se llame a findById() con "1", devuelve una Carrera opcional.
        when(courseRepository.findById(id)).thenReturn(Optional.of(curso));

        // Llama al método findByCodigo() del servicio.
        Course found = courseRepository.findById(id).get();

        // Verifica que la Carrera devuelta no sea nula y que su código coincida con el código esperado.
        assertNotNull(found);
        assertEquals(id, found.getId());
    }

    @Test
    public void testSave() {

        // Define el comportamiento del mock: cuando se llame a save(), devuelve la Carrera proporcionada.
        when(courseRepository.save(curso)).thenReturn(curso);

        // Llama al método save() del servicio.
        Course saved = courseService.save(curso);

        // Verifica que la Carrera guardada no sea nula y que su nombre coincida con el nombre esperado.
        assertNotNull(saved);
        assertEquals("Ingeniería", saved.getTitulo());
    }


}
