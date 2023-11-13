package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Envios")

public class Envios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnvio")
    private Integer idEnvio;
    @Column(name = "direccion")
    private String direccionEnvio;
    @OneToOne
    @JoinColumn(name = "idTecnico")
    private Tecnicos tecnicos;
    @ManyToOne
    @JoinColumn(name = "EstadoEnvio_idEstadoEnvio")
    private EstadosEnvios estadosEnvios;

    public Envios() {
    }

    public Envios(Integer idEnvio, String direccionEnvio, Tecnicos tecnicos, EstadosEnvios estadosEnvios) {
        this.idEnvio = idEnvio;
        this.direccionEnvio = direccionEnvio;
        this.tecnicos = tecnicos;
        this.estadosEnvios = estadosEnvios;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
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

    public EstadosEnvios getEstadosEnvios() {
        return estadosEnvios;
    }

    public void setEstadosEnvios(EstadosEnvios estadosEnvios) {
        this.estadosEnvios = estadosEnvios;
    }
}
