package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Permisos")
public class Permisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPermiso")
    private Integer idPermiso;
    private String nombrePermiso;

    //Constructores

    public Permisos() {
    }

    public Permisos(Integer idPermiso, String nombrePermiso) {
        this.idPermiso = idPermiso;
        this.nombrePermiso = nombrePermiso;
    }

   //Getter y Setter

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }
}
