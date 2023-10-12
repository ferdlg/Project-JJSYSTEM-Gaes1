package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.text.DateFormat;

@Entity
@Table(name = "Cotizaciones")

public class Cotizaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCotizacion")
    private Integer id;

    private DateFormat fechaCotizacion;

    private String productoCotizacion;

    private String servicioCotizacion;

    private Float totalCotizacion;

    private String descripcionCotizacion;

    public Cotizaciones() {
    }

    public Cotizaciones(Integer id, DateFormat fechaCotizacion, String productoCotizacion, String servicioCotizacion, Float totalCotizacion, String descripcionCotizacion) {
        this.id = id;
        this.fechaCotizacion = fechaCotizacion;
        this.productoCotizacion = productoCotizacion;
        this.servicioCotizacion = servicioCotizacion;
        this.totalCotizacion = totalCotizacion;
        this.descripcionCotizacion = descripcionCotizacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DateFormat getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(DateFormat fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public String getProductoCotizacion() {
        return productoCotizacion;
    }

    public void setProductoCotizacion(String productoCotizacion) {
        this.productoCotizacion = productoCotizacion;
    }

    public String getServicioCotizacion() {
        return servicioCotizacion;
    }

    public void setServicioCotizacion(String servicioCotizacion) {
        this.servicioCotizacion = servicioCotizacion;
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
}
