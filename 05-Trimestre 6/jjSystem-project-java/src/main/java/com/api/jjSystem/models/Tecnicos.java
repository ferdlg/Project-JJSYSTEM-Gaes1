package com.api.jjSystem.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigInteger;

@Entity
@Table(name = "tecnicos")
public class Tecnicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTecnico")
    private Integer idTecnico;
    private String especialidad;
    private BigInteger numeroDocumento;
    //Constructores
    public Tecnicos() {
    }

    public Tecnicos(Integer idTecnico, String especialidad, BigInteger numeroDocumento) {
        this.idTecnico = idTecnico;
        this.especialidad = especialidad;
        this.numeroDocumento = numeroDocumento;
    }
    //Get y set
    public Integer getId() {
        return idTecnico;
    }

    public void setId(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public BigInteger getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(BigInteger numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
