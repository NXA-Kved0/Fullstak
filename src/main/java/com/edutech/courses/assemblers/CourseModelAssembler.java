package com.edutech.courses.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.edutech.courses.controller.CourseControllerV2;
import com.edutech.courses.model.Course;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
@Component
public class CourseModelAssembler implements RepresentationModelAssembler<Course, EntityModel<Course>> {
    @Override
    public EntityModel<Course> toModel(Course course) {
        return EntityModel.of(course,
                linkTo(methodOn(CourseControllerV2.class).getCourseById(course.getId())).withSelfRel(),
                linkTo(methodOn(CourseControllerV2.class).getAllCourse()).withRel("cursos"));
    }
}