package com.api.rest.publicaciones.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detalles")
public class InstructorDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_detalle_id")
    private Long id;
    @Column(name = "canal_youtube")
    private String canalYouTube;
    @Column(name = "pasa_tiempo")
    private String pasatiempo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCanalYouTube() {
        return canalYouTube;
    }

    public void setCanalYouTube(String canalYouTube) {
        this.canalYouTube = canalYouTube;
    }

    public String getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(String pasatiempo) {
        this.pasatiempo = pasatiempo;
    }
}
