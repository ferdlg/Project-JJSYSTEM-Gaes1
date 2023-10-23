package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "cotizaciones")

public class Cotizaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCotizacion")
    private Integer idCotizacion;
    @Column(name = "fechaCotizacion")
    private Date fechaCotizacion;
    @Column(name = "totalCotizacion")
    private Float totalCotizacion;
    @Column(name = "descripcionCotizacion")
    private String descripcionCotizacion;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Productos productos;
    @ManyToOne
    @JoinColumn(name = "idServicio")
    private Servicios servicios;


    //Constructores

    public Cotizaciones() {
    }

    public Cotizaciones(Integer idCotizacion, Date fechaCotizacion, Float totalCotizacion, String descripcionCotizacion, Clientes clientes, Productos productos, Servicios servicios) {
        this.idCotizacion = idCotizacion;
        this.fechaCotizacion = fechaCotizacion;
        this.totalCotizacion = totalCotizacion;
        this.descripcionCotizacion = descripcionCotizacion;
        this.clientes = clientes;
        this.productos = productos;
        this.servicios = servicios;
    }

    //Getter y Setter

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public Float getTotalCotizacion() {
        return totalCotizacion;
    }

    public void setTotalCotizacion(Float totalCotizacion) {
        this.totalCotizacion = totalCotizacion;
    }

    public String getDescripcionCotizacion() {
        return descripcionCotizacion;
    }

    public void setDescripcionCotizacion(String descripcionCotizacion) {
        this.descripcionCotizacion = descripcionCotizacion;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }
}
