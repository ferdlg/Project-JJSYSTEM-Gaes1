package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CategoriaServicios")

public class CategoriaServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriaServicio")
    private Integer id;
    @Column(name = "nombreCategoria")
    private String nombreCategoria;

    //Constructores

    public CategoriaServicios() {
    }

    public CategoriaServicios(Integer id, String nombreCategoria) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
    }

    //Getter y Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
