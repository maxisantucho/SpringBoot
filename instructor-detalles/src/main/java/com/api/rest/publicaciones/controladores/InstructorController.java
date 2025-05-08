package com.api.rest.publicaciones.controladores;

import com.api.rest.publicaciones.entidades.Instructor;
import com.api.rest.publicaciones.excepciones.ResourceNotFoundException;
import com.api.rest.publicaciones.repositorios.InstructorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping("/instructores")
    public List<Instructor> listarInstructores() {
        return instructorRepository.findAll();
    }

    @GetMapping("/instructores/{id}")
    public ResponseEntity<Instructor> verDetallesDelInstructor(@PathVariable Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor con ID " +
                        id + " no se ha encontrado"));
        return ResponseEntity.ok().body(instructor);
    }

    @PostMapping("/instructores")
    public Instructor guardarInstructor(@Valid @RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @PutMapping("/instructores/{id}")
    public ResponseEntity<Instructor> actualizarInstructor(@PathVariable Long id, @Valid @RequestBody Instructor instructor) {
        Instructor instructorBuscado = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor con ID " +
                        id + " no se ha encontrado"));
        instructorBuscado.setEmail(instructor.getEmail());
        Instructor instructorActualizado = instructorRepository.save(instructorBuscado);
        return ResponseEntity.ok(instructorActualizado);
    }

    @DeleteMapping("/instructores/{id}")
    public Map<String, Boolean> eliminarInstructor(@PathVariable Long id) {
        Instructor instructorBuscado = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor con ID " +
                        id + " no se ha encontrado"));
        instructorRepository.delete(instructorBuscado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Instructor eliminado", Boolean.TRUE);
        return respuesta;
    }

}
