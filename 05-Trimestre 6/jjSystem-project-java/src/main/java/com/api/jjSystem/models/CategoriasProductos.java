package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CategoriasProductos")
public class CategoriasProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriaProducto")
    private Integer idCategoriaProducto;
    @Column(name = "nombreCategoria")
    private String nombreCategoria;

    //Constructores
    public CategoriasProductos() {
    }

    public CategoriasProductos(Integer idCategoriaProducto, String nombreCategoria) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombreCategoria = nombreCategoria;
    }

    //Getter y Setter

    public Integer getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(Integer idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
