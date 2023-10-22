package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoPQRSF")
public class TipoPQRSF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoPQRSF")
    private Integer id;

    private String nombreTipoPQRSF;

    public TipoPQRSF() {
    }

    public TipoPQRSF(Integer id, String nombreTipoPQRSF) {
        this.id = id;
        this.nombreTipoPQRSF = nombreTipoPQRSF;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTipoPQRSF() {
        return nombreTipoPQRSF;
    }

    public void setNombreTipoPQRSF(String nombreTipoPQRSF) {
        this.nombreTipoPQRSF = nombreTipoPQRSF;
    }
}
