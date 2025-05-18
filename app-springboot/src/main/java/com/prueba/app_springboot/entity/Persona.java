package com.prueba.app_springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_personas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    private Long id;
    private String nombre;
    private int edad;

}
