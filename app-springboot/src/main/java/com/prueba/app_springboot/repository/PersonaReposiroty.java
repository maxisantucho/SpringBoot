package com.prueba.app_springboot.repository;

import com.prueba.app_springboot.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaReposiroty extends JpaRepository<Persona, Long> {
}
