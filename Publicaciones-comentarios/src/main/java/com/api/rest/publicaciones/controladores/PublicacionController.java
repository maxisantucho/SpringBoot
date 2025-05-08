package com.api.rest.publicaciones.controladores;

import com.api.rest.publicaciones.entidades.Publicacion;
import com.api.rest.publicaciones.repositorios.PublicacionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;

@RestController
public class PublicacionController {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @GetMapping("/publicaciones")
    public Page<Publicacion> listarPublicaciones(Pageable pageable) {
        return publicacionRepository.findAll(pageable);
    }

    @PostMapping("/publicaciones")
    public Publicacion guardarPublicaciones(@Valid @RequestBody Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @PutMapping("/publicaciones/{publicacionId}")
    public Publicacion actualizarPublicacion(@PathVariable Long publicacionId, @Valid @RequestBody Publicacion publicacionRequest) {
        return publicacionRepository.findById(publicacionId).map(publicacion -> {
            publicacion.setTitulo(publicacionRequest.getTitulo());
            publicacion.setDescripcion((publicacionRequest.getDescripcion()));
            publicacion.setContenido(publicacionRequest.getContenido());
            return publicacionRepository.save(publicacion);
        }).orElseThrow(() -> new ResolutionException("Publicacion con el ID: "
                + publicacionId + " no encontrada"));
    }

    @DeleteMapping("/publicaciones/{publicacionId}")
    public ResponseEntity<?> eliminarPublicacion(@PathVariable Long publicacionId) {
        return publicacionRepository.findById(publicacionId).map(publicacion -> {
            publicacionRepository.delete(publicacion);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResolutionException("Publicacion con el ID: "
                + publicacionId + " no encontrada"));
    }

}
