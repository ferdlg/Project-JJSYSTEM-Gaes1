package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CategoriaServicios")

public class CategoriaServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriaServicio")
    private Integer idCategoriaServicio;
    @Column(name = "nombreCategoria")
    private String nombreCategoria;

    public CategoriaServicios() {
    }

    public CategoriaServicios(Integer idCategoriaServicio, String nombreCategoria) {
        this.idCategoriaServicio = idCategoriaServicio;
        this.nombreCategoria = nombreCategoria;
    }

    public Integer getId() {
        return idCategoriaServicio;
    }

    public void setId(Integer idCategoriaServicio) {
        this.idCategoriaServicio = idCategoriaServicio;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
