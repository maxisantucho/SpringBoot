package com.prueba.app_springboot;

import com.prueba.app_springboot.entity.Persona;
import com.prueba.app_springboot.repository.PersonaReposiroty;
import com.prueba.app_springboot.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AppSpringbootApplication  implements CommandLineRunner {

	@Autowired
	private PersonaService personaService;

	public static void main(String[] args) {

		SpringApplication.run(AppSpringbootApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		personaService.crearPersona(new Persona(5L, "Jose", 17));
		personaService.crearPersona(new Persona(6L, "David", 18));
		personaService.crearPersona(new Persona(7L, "Mariano", 20));
		personaService.crearPersona(new Persona(8L, "Javier", 18));

		System.out.println("Numero de personas en la tabla: " + personaService.contarPersonas());

		List<Persona> personas = personaService.obtenerTodas();
		personas.forEach(p -> System.out.println("Nombre : " + p.getNombre()));

	}
}
