package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Permisos")
public class Permisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPermiso")
    private Integer id;

    private String nombrePermiso;

    public Permisos() {
    }

    public Permisos(Integer id, String nombrePermiso) {
        this.id = id;
        this.nombrePermiso = nombrePermiso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }
}
