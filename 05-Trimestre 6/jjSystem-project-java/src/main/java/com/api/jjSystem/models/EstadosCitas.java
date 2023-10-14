package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table

public class EstadosCitas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoCita")
    private Integer id;
    @Column(name = "nombreEstadoCita")
    private String nombreEstadoCita;
    public EstadosCitas() {
    }
    public EstadosCitas(Integer id, String nombreEstadoCita) {
        this.id = id;
        this.nombreEstadoCita = nombreEstadoCita;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstadoCita() {
        return nombreEstadoCita;
    }

    public void setNombreEstadoCita(String nombreEstadoCita) {
        this.nombreEstadoCita = nombreEstadoCita;
    }
}
