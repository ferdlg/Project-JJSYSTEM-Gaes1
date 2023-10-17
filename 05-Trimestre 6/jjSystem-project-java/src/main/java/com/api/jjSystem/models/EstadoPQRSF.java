package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadoPQRSF")
public class EstadoPQRSF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoPQRSF")
    private Integer id;

    private String nombreEstadoPQRSF;

    public EstadoPQRSF() {
    }

    public EstadoPQRSF(Integer id, String nombreEstadoPQRSF) {
        this.id = id;
        this.nombreEstadoPQRSF = nombreEstadoPQRSF;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstadoPQRSF() {
        return nombreEstadoPQRSF;
    }

    public void setNombreEstadoPQRSF(String nombreEstadoPQRSF) {
        this.nombreEstadoPQRSF = nombreEstadoPQRSF;
    }
}