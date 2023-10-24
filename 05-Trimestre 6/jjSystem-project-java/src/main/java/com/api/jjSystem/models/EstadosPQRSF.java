package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estadosPQRSF")
public class EstadosPQRSF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoPQRSF")
    private Integer idEstadoPQRSF;
    private String nombreEstadoPQRSF;

    public EstadosPQRSF() {
    }

    public EstadosPQRSF(Integer idEstadoPQRSF, String nombreEstadoPQRSF) {
        this.idEstadoPQRSF = idEstadoPQRSF;
        this.nombreEstadoPQRSF = nombreEstadoPQRSF;
    }

    public Integer getIdEstadoPQRSF() {
        return idEstadoPQRSF;
    }

    public void setIdEstadoPQRSF(Integer idEstadoPQRSF) {
        this.idEstadoPQRSF = idEstadoPQRSF;
    }

    public String getNombreEstadoPQRSF() {
        return nombreEstadoPQRSF;
    }

    public void setNombreEstadoPQRSF(String nombreEstadoPQRSF) {
        this.nombreEstadoPQRSF = nombreEstadoPQRSF;
    }

}
