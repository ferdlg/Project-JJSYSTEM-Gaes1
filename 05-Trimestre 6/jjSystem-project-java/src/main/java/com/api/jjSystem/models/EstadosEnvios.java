package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadoEnvios")
public class EstadosEnvios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoEnvio")
    private Integer idEstadoEnvio;

    private String nombreEstadoEnvio;

    public EstadosEnvios() {
    }

    public EstadosEnvios(Integer idEstadoEnvio, String nombreEstadoEnvio) {
        this.idEstadoEnvio = idEstadoEnvio;
        this.nombreEstadoEnvio = nombreEstadoEnvio;
    }

    public Integer getIdEstadoEnvio() {
        return idEstadoEnvio;
    }

    public void setIdEstadoEnvio(Integer idEstadoEnvio) {
        this.idEstadoEnvio = idEstadoEnvio;
    }

    public String getNombreEstadoEnvio() {
        return nombreEstadoEnvio;
    }

    public void setNombreEstadoEnvio(String nombreEstadoEnvio) {
        this.nombreEstadoEnvio = nombreEstadoEnvio;
    }
}
