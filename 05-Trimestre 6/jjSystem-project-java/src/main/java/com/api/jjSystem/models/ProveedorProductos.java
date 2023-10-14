package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ProveedorProductos")

public class ProveedorProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedorProducto")
    private Integer idProveedorProducto;

    private String nombreProveedor;

    public ProveedorProductos() {
    }

    public ProveedorProductos(Integer idProveedorProducto, String nombreProveedor) {
        this.idProveedorProducto = idProveedorProducto;
        this.nombreProveedor = nombreProveedor;
    }

    public Integer getId() {
        return idProveedorProducto;
    }

    public void setId(Integer idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
}
