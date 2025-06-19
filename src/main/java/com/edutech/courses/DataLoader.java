package com.edutech.courses;

import com.edutech.courses.model.Course;
import com.edutech.courses.repository.CourseRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();
// Generar cursos
        for (int i = 0; i < 50; i++) {
            Course course = new Course();
            course.setTitulo(faker.educator().course());
            course.setDescripcion(faker.lorem().paragraph(3));
            course.setProfesor(faker.name().fullName());
            double precioBruto = faker.number().numberBetween(10000.0, 100000.0);
            course.setPrecio(precioBruto);
            courseRepository.save(course);
        }
    }
}