package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")

public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Column(name = "descripcionProducto")
    private String descripcionProducto;
    @Column(name = "precioProducto")
    private Float precioProducto;
    @Column(name = "cantidad")
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "idAdministrador")
    private Administrador administrador;
    @OneToOne
    @JoinColumn(name = "idCategoriaProducto")
    private CategoriasProductos categoriasProductos;
    @ManyToOne
    @JoinColumn(name = "idProveedorProducto")
    private ProveedoresProductos proveedoresProductos;

    //Constructores

    public Productos() {
    }

    public Productos(Integer idProducto, String nombreProducto, String descripcionProducto, Float precioProducto, Integer cantidad, Administrador administrador, CategoriasProductos categoriasProductos, ProveedoresProductos proveedoresProductos) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
        this.administrador = administrador;
        this.categoriasProductos = categoriasProductos;
        this.proveedoresProductos = proveedoresProductos;
    }

    //Getter y Setter

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
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

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public CategoriasProductos getCategoriaProductos() {
        return categoriasProductos;
    }

    public void setCategoriaProductos(CategoriasProductos categoriasProductos) {
        this.categoriasProductos = categoriasProductos;
    }

    public ProveedoresProductos getProveedorProductos() {
        return proveedoresProductos;
    }

    public void setProveedorProductos(ProveedoresProductos proveedoresProductos) {
        this.proveedoresProductos = proveedoresProductos;
    }
}