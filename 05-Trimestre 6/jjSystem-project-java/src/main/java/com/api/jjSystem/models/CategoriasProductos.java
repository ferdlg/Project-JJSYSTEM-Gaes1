package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CategoriaProductos")
public class CategoriasProductos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriaProducto")
    private Integer idCategoriaProducto;
    @Column(name = "nombreCategoria")
    private String nombreCategoria;

    public CategoriasProductos() {
    }

    public CategoriasProductos(Integer idCategoriaProducto, String nombreCategoria) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombreCategoria = nombreCategoria;
    }

    public Integer getId() {
        return idCategoriaProducto;
    }

    public void setId(Integer id) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
