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
    @Column(name = "direccionCliente")
    private String direccionCliente;
    @Column(name = "numeroDocumento")
    private BigInteger numeroDocumento;

    //Constructores
    public Clientes() {
    }

    public Clientes(Integer idCliente, String direccionCliente, BigInteger numeroDocumento) {
        this.idCliente = idCliente;
        this.direccionCliente = direccionCliente;
        this.numeroDocumento = numeroDocumento;
    }

    //get y set

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public BigInteger getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(BigInteger numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
