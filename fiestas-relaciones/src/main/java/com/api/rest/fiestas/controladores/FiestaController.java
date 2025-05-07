package com.api.rest.fiestas.controladores;

import com.api.rest.fiestas.entidades.Fiesta;
import com.api.rest.fiestas.repositorios.FiestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/fiestas")
public class FiestaController {

    @Autowired
    private FiestaRepository fiestaRepository;

    @GetMapping
    public ResponseEntity<Collection<Fiesta>> listarFiestas() {
        return new ResponseEntity<>(fiestaRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fiesta> obtenerFiestaPorId(@PathVariable long id) {
        Fiesta fiesta = fiestaRepository.findById(id).orElseThrow();
        if(fiesta != null) {
            return new ResponseEntity<>(fiestaRepository.findById(id).orElseThrow(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarFiesta(@RequestBody Fiesta fiesta) {
        return new ResponseEntity<>(fiestaRepository.save(fiesta), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFiesta(@PathVariable long id) {
        fiestaRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
