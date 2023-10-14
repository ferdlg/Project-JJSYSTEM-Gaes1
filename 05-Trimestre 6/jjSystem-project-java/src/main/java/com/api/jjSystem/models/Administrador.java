package com.api.jjSystem.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigInteger;

@Entity
@Table(name = "Administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdministrador")
    private Integer idAdministrador;
    @Column(name = "numeroDocumento")
    private BigInteger numeroDocumento;

    public Administrador() {
    }
    public Administrador(Integer idAdministrador, BigInteger numeroDocumento) {
        this.idAdministrador = idAdministrador;
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getId() {
        return idAdministrador;
    }

    public void setId(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public BigInteger getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(BigInteger numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
