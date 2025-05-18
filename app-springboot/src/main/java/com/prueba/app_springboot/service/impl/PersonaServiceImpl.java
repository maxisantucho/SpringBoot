package com.prueba.app_springboot.service.impl;

import com.prueba.app_springboot.entity.Persona;
import com.prueba.app_springboot.repository.PersonaReposiroty;
import com.prueba.app_springboot.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaReposiroty personaReposiroty;

    @Override
    public List<Persona> obtenerTodas() {
        return personaReposiroty.findAll();
    }

    @Override
    public Persona obtenerPorId(Long id) {
        return personaReposiroty.findById(id).orElse(null);
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaReposiroty.save(persona);
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
        Persona personaBBDD = personaReposiroty.findById(id).orElse(null);
        if(personaBBDD != null) {
            personaBBDD.setNombre(persona.getNombre());
            personaBBDD.setEdad(persona.getEdad());
            return personaReposiroty.save(personaBBDD);
        }
        return null;
    }

    @Override
    public void eliminarPersona(Long id) {
        personaReposiroty.deleteById(id);
    }

    @Override
    public long contarPersonas() {
        return personaReposiroty.count();
    }

}
