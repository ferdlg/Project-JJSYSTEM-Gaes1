package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CategoriasServicios")

public class CategoriasServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriaServicio")
    private Integer idCategoriaServicio;
    @Column(name = "nombreCategoria")
    private String nombreCategoria;

    //Constructores

    public CategoriasServicios() {
    }

    public CategoriasServicios(Integer idCategoriaServicio, String nombreCategoria) {
        this.idCategoriaServicio = idCategoriaServicio;
        this.nombreCategoria = nombreCategoria;
    }

    //Getter y Setter

    public Integer getIdCategoriaServicio() {
        return idCategoriaServicio;
    }

    public void setIdCategoriaServicio(Integer idCategoriaServicio) {
        this.idCategoriaServicio = idCategoriaServicio;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
