package com.api.rest.fiestas.repositorios;

import com.api.rest.fiestas.entidades.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

    Collection<Persona> findAll();

}
