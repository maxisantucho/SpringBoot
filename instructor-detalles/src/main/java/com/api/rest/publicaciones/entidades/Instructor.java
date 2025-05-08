package com.api.rest.publicaciones.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "instructores")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    @OneToOne
    @JoinColumn(name = "instructor_detalle_id")
    private InstructorDetalle instructorDetalle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetalle getInstructorDetalle() {
        return instructorDetalle;
    }

    public void setInstructorDetalle(InstructorDetalle instructorDetalle) {
        this.instructorDetalle = instructorDetalle;
    }
}
