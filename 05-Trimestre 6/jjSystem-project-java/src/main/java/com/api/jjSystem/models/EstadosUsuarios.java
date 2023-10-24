package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "EstadosUsuarios")

public class EstadosUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoUsuario")
    private Integer id;
    @Column(name = "nombreEstadoUsuario")
    private String nombreEstadoUsuario;

    //Constructores

    public EstadosUsuarios() {
    }

    public EstadosUsuarios(Integer id, String nombreEstadoUsuario) {
        this.id = id;
        this.nombreEstadoUsuario = nombreEstadoUsuario;
    }

    //Getter y Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstadoUsuario() {
        return nombreEstadoUsuario;
    }

    public void setNombreEstadoUsuario(String nombreEstadoUsuario) {
        this.nombreEstadoUsuario = nombreEstadoUsuario;
    }

}
