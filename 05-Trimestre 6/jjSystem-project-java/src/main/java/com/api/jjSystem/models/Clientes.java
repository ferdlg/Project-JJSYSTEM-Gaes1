package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "numeroDocumento")
    private BigInteger numeroDocumento;

    //Constructores
    public Clientes() {
    }

    public Clientes(Integer idCliente, String direccion, BigInteger numeroDocumento) {
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.numeroDocumento = numeroDocumento;
    }
    //get y set

    public Integer getId() {
        return idCliente;
    }

    public void setId(Integer idCliente) {
        this.idCliente = idCliente;
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
