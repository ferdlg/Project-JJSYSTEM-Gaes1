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

    @ManyToOne
    @JoinColumn(name = "Usuarios_numeroDocumento")
    private Usuarios usuarios;
    //Constructores

    public EstadosUsuarios() {
    }

    public EstadosUsuarios(Integer id, String nombreEstadoUsuario, Usuarios usuarios) {
        this.id = id;
        this.nombreEstadoUsuario = nombreEstadoUsuario;
        this.usuarios = usuarios;
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

    public Usuarios getUsuarios(){
        return usuarios;
    }
    public void setUsuarios(Usuarios usuarios)
    {
        this.usuarios = usuarios;
    }
}
