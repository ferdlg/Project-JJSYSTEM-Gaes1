package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CategoriaProductos")
public class CategoriaProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriaProducto")
    private Integer id;
    @Column(name = "nombreCategoria")
    private String nombreCategoria;

    //Constructores
    public CategoriaProductos() {
    }

    public CategoriaProductos(Integer id, String nombreCategoria) {
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