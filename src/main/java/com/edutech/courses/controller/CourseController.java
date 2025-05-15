package com.edutech.courses.controller;

import com.edutech.courses.model.Course;
import com.edutech.courses.repository.CourseRepository;
import com.edutech.courses.service.CourseService;
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
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @PostMapping
    public ResponseEntity createCourse(@RequestBody Course course) {
        Course nuevo = courseService.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }


}