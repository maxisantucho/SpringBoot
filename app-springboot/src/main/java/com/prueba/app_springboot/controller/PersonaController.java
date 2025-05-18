package com.prueba.app_springboot.controller;

import com.prueba.app_springboot.entity.Persona;
import com.prueba.app_springboot.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    public String listarPersonas(Model model) {
        List<Persona> personas = personaService.obtenerTodas();
        model.addAttribute("");
        return "personas";
    }

}
