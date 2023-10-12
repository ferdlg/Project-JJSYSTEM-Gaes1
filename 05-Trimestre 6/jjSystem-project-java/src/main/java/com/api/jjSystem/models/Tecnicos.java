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
    private Integer id;
    private String especialidad;
    private BigInteger numeroDocumento;
    //Constructores
    public Tecnicos() {
    }

    public Tecnicos(Integer id, String especialidad, BigInteger numeroDocumento) {
        this.id = id;
        this.especialidad = especialidad;
        this.numeroDocumento = numeroDocumento;
    }
    //Get y set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
