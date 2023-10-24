package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tiposPQRSF")
public class TiposPQRSF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoPQRSF")
    private Integer idTipoPQRSF;
    private String nombreTipoPQRSF;

    public TiposPQRSF() {
    }

    public TiposPQRSF(Integer idTipoPQRSF, String nombreTipoPQRSF) {
        this.idTipoPQRSF = idTipoPQRSF;
        this.nombreTipoPQRSF = nombreTipoPQRSF;
    }

    public Integer getIdTipoPQRSF() {
        return idTipoPQRSF;
    }

    public void setIdTipoPQRSF(Integer idTipoPQRSF) {
        this.idTipoPQRSF = idTipoPQRSF;
    }

    public String getNombreTipoPQRSF() {
        return nombreTipoPQRSF;
    }

    public void setNombreTipoPQRSF(String nombreTipoPQRSF) {
        this.nombreTipoPQRSF = nombreTipoPQRSF;
    }
}
