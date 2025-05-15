package com.edutech.courses.service;


import com.edutech.courses.model.Course;
import com.edutech.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
