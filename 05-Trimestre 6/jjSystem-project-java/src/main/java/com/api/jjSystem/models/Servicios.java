package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicios")

public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private Integer idServicio;

    private String nombreServicio;

    private String descripcionServicio;

    public Servicios() {
    }

    public Servicios(Integer idServicio, String nombreServicio, String descripcionServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
    }

    public Integer getId() {
        return idServicio;
    }

    public void setId(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }
}
