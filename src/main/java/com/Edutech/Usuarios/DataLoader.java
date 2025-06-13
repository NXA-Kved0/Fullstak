package com.Edutech.Usuarios;


import com.Edutech.Usuarios.model.Usuarios;
import com.Edutech.Usuarios.repository.UsuariosRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();
// Generar usuarios
        for (int i = 0; i < 50; i++) {
            Usuarios usuarios = new Usuarios();
            usuarios.setNombre(faker.name().fullName());
            usuarios.setCorreo(faker.internet().emailAddress());
            usuarios.setClave(""+faker.number().numberBetween(0000, 9999));
            usuariosRepository.save(usuarios);
        }
    }
}