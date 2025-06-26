package com.edutech.courses.controller;
import com.edutech.courses.assemblers.CourseModelAssembler;
import com.edutech.courses.model.Course;
import com.edutech.courses.service.CourseService;
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
@RequestMapping("/api/v2/cursos")
public class CourseControllerV2 {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseModelAssembler assembler;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public CollectionModel<EntityModel<Course>> getAllCourse() {
        List<EntityModel<Course>> courses = courseService.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(courses,
                linkTo(methodOn(CourseControllerV2.class).getAllCourse()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public EntityModel<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.findById(id);
        return assembler.toModel(course);
    }

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Course>> createCourse(@RequestBody Course course) {
        Course newCourse = courseService.save(course);
        return ResponseEntity
                .created(linkTo(methodOn(CourseControllerV2.class).getCourseById(newCourse.getId())).toUri())
                .body(assembler.toModel(newCourse));
    }

    @PutMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<EntityModel<Course>> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        Course updatedCourse = courseService.save(course);
        return ResponseEntity.ok(assembler.toModel(updatedCourse));
    }

    @DeleteMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}