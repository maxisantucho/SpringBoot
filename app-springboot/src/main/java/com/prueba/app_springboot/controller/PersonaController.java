package com.prueba.app_springboot.controller;

import com.prueba.app_springboot.entity.Persona;
import com.prueba.app_springboot.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public String listarPersonas(Model model) {
        List<Persona> personas = personaService.obtenerTodas();
        model.addAttribute("listaPersonas", personas);
        return "listar";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioDeNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("accion", "/personas/nueva");
        return "formulario";
    }

    @PostMapping("/nueva")
    public String guardarPersonaNueva(@ModelAttribute Persona persona) {
        personaService.crearPersona(persona);
        return "redirect:/personas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id,
                                                 @ModelAttribute Persona persona,
                                                 Model model) {
        model.addAttribute("persona", persona);
        model.addAttribute("accion", "/personas/editar/" + id);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona) {
        personaService.actualizarPersona(id, persona);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }

}
