package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ProveedorProductos")

public class ProveedorProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedorProducto")
    private Integer id;

    private String nombreProveedor;

    public ProveedorProductos() {
    }

    public ProveedorProductos(Integer id, String nombreProveedor) {
        this.id = id;
        this.nombreProveedor = nombreProveedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
}
