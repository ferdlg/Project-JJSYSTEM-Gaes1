package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Integer id;
    private String direccion;
    private BigInteger numeroDocumento;

    //Constructores
    public Clientes() {
    }

    public Clientes(Integer id, String direccion, BigInteger numeroDocumento) {
        this.id = id;
        this.direccion = direccion;
        this.numeroDocumento = numeroDocumento;
    }
    //get y set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(BigInteger numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
