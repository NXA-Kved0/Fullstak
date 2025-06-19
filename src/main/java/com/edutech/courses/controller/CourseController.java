package com.edutech.courses.controller;

import com.edutech.courses.model.Course;
import com.edutech.courses.repository.CourseRepository;
import com.edutech.courses.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    @Operation(summary = "Obtener todos los cursos", description = "Permite ver todos los cursos")
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear un curso", description = "Permite la creacion de un curso")
    public ResponseEntity createCourse(@RequestBody Course course) {
        Course nuevo = courseService.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un curso", description = "Elimina un curso por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un Curso", description = "Actualiza los datos de un Curso existente por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso actualizado"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    public ResponseEntity<Course> updateCourse(
            @PathVariable Long id,
            @RequestBody Course courseUpdateRequest) {
        Course updatedCourse = courseService.updateCourse(id, courseUpdateRequest);
        return ResponseEntity.ok(updatedCourse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un Curso", description = "Obtiene un curso por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso encontrado"),
            @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }


}