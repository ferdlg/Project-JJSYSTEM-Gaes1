package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Envios")
public class Envios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnvio")
    private Integer id;

    @Column(name = "direccion")
    private String direccionEnvio;

    @OneToOne
    @JoinColumn(name = "idTecnico")
    private Tecnicos tecnicos;

    @ManyToOne
    @JoinColumn(name = "EstadoEnvio_idEstadoEnvio")
    private EstadoEnvios estadoEnvios;

    public Envios() {
    }

    public Envios(Integer id, String direccionEnvio, Tecnicos tecnicos, EstadoEnvios estadoEnvios) {
        this.id = id;
        this.direccionEnvio = direccionEnvio;
        this.tecnicos = tecnicos;
        this.estadoEnvios = estadoEnvios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Tecnicos getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(Tecnicos tecnicos) {
        this.tecnicos = tecnicos;
    }

    public EstadoEnvios getEstadoEnvios() {
        return estadoEnvios;
    }

    public void setEstadoEnvios(EstadoEnvios estadoEnvios) {
        this.estadoEnvios = estadoEnvios;
    }
}
