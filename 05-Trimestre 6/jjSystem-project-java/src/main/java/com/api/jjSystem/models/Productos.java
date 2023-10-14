package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Productos")

public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Column(name = "idProducto")
    private String nombreProducto;
    @Column(name = "nombreProducto")
    private String descripcionProducto;
    @Column(name = "descripcionProducto")
    private Float precioProducto;
    @Column(name = "precioProducto")
    private Integer cantidad;

    public Productos() {
    }

    public Productos(Integer idProducto, String nombreProducto, String descripcionProducto, Float precioProducto, Integer cantidad) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return idProducto;
    }

    public void setId(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}