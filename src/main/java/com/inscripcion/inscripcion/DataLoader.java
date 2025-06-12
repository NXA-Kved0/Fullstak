package com.inscripcion.inscripcion;

import com.inscripcion.inscripcion.model.Inscripcion;
import com.inscripcion.inscripcion.repository.*;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Profile("default")
@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();

        //Generar inscripcion
        for (int i = 0; i < 5; i++) {
            Inscripcion inscripcion = new Inscripcion();

            inscripcion.setRun(faker.idNumber().valid());
            inscripcion.setNombre(faker.name().name());
            inscripcion.setApellido(faker.name().lastName());
            inscripcion.setFechaNacimiento(new Date());
            inscripcion.setFechaIncripcion(new Date());
            inscripcion.setCorreo(faker.internet().emailAddress());
            inscripcion.setContactoEmergencia(faker.internet().emailAddress());
            inscripcionRepository.save(inscripcion);

        }
    }

}
