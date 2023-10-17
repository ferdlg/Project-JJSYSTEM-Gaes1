package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ProveedorProductos")

public class ProveedorProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedorProducto")
    private Integer idProveedorProducto;
    @Column(name = "nombreProveedor")
    private String nombreProveedor;

    //Constuctores

    public ProveedorProductos() {
    }

    public ProveedorProductos(Integer idProveedorProducto, String nombreProveedor) {
        this.idProveedorProducto = idProveedorProducto;
        this.nombreProveedor = nombreProveedor;
    }

    //Getter y Setter

    public Integer getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(Integer idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
}
