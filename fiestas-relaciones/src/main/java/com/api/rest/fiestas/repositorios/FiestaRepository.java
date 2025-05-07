package com.api.rest.fiestas.repositorios;

import com.api.rest.fiestas.entidades.Fiesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FiestaRepository extends CrudRepository<Fiesta, Long> {

    Collection<Fiesta> findAll();

}
