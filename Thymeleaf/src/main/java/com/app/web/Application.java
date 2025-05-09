package com.app.web;

import com.app.web.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private EstudianteRepositorio estudianteRepositorio;

	@Override
	public void run(String... args) throws Exception {
		/*Estudiante estudiante1 = new Estudiante("Christian", "Ramirez", "chris1020@gmail.com");
		estudianteRepositorio.save(estudiante1);
		Estudiante estudiante2 = new Estudiante("Andre", "Carrillo", "andrecar13@gmail.com");
		estudianteRepositorio.save(estudiante2);*/
	}
}
