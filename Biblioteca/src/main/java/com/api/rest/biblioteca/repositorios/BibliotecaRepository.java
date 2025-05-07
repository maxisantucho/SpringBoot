package com.api.rest.biblioteca.repositorios;

import com.api.rest.biblioteca.entidades.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer> {

}
