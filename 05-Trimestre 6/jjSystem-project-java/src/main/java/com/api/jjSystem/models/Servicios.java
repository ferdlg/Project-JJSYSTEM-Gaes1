package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicios")

public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private Integer id;

    private String nombreServicio;

    private String descripcionServicio;

    public Servicios() {
    }

    public Servicios(Integer id, String nombreServicio, String descripcionServicio) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
