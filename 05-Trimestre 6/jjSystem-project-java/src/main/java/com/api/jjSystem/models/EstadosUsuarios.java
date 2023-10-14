package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "EstadosUsuarios")

public class EstadosUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadoUsuario")
    private Integer idEstadoUsuario;

    private String nombreEstadoUsuario;

    public EstadosUsuarios() {
    }

    public EstadosUsuarios(Integer idEstadoUsuario, String nombreEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
        this.nombreEstadoUsuario = nombreEstadoUsuario;
    }

    public Integer getId() {
        return idEstadoUsuario;
    }

    public void setId(Integer idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public String getNombreEstadoUsuario() {
        return nombreEstadoUsuario;
    }

    public void setNombreEstadoUsuario(String nombreEstadoUsuario) {
        this.nombreEstadoUsuario = nombreEstadoUsuario;
    }
}
