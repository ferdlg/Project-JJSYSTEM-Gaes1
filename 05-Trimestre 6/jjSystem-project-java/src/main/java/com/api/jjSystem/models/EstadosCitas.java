package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table

public class EstadosCitas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoCita")
    private Integer idEstadoCita;
    @Column(name = "nombreEstadoCita")
    private String nombreEstadoCita;
    public EstadosCitas() {
    }
    public EstadosCitas(Integer idEstadoCita, String nombreEstadoCita) {
        this.idEstadoCita = idEstadoCita;
        this.nombreEstadoCita = nombreEstadoCita;
    }
    public Integer getId() {
        return idEstadoCita;
    }

    public void setId(Integer idEstadoCita) {
        this.idEstadoCita = idEstadoCita;
    }

    public String getNombreEstadoCita() {
        return nombreEstadoCita;
    }

    public void setNombreEstadoCita(String nombreEstadoCita) {
        this.nombreEstadoCita = nombreEstadoCita;
    }
}
