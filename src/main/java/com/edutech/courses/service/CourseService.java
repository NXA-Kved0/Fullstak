package com.edutech.courses.service;


import com.edutech.courses.model.Course;
import com.edutech.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course save(Course course){
        return courseRepository.save(course);
    }

    public List <Course> findAll(){
        return courseRepository.findAll();
    }

    @Transactional
    public Course updateCourse(Long id, Course courseUpdateRequest) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));

        if (courseUpdateRequest.getTitulo() != null) {
            existingCourse.setTitulo(courseUpdateRequest.getTitulo());
        }
        if (courseUpdateRequest.getDescripcion() != null) {
            existingCourse.setDescripcion(courseUpdateRequest.getDescripcion());
        }

        return courseRepository.save(existingCourse);
    }


    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }





}

