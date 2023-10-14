package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadoEnvios")
public class EstadoEnvios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoEnvio")
    private Integer id;

    private String nombreEstadoEnvio;

    public EstadoEnvios() {
    }

    public EstadoEnvios(Integer id, String nombreEstadoEnvio) {
        this.id = id;
        this.nombreEstadoEnvio = nombreEstadoEnvio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstadoEnvio() {
        return nombreEstadoEnvio;
    }

    public void setNombreEstadoEnvio(String nombreEstadoEnvio) {
        this.nombreEstadoEnvio = nombreEstadoEnvio;
    }
}
