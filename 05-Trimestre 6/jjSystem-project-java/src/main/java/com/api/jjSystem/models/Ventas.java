package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.text.DateFormat;

@Entity
@Table(name = "Ventas")

public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Integer idVenta;
    @Column(name = "fechaVenta")
    private DateFormat fechaVenta;
    @OneToOne
    @JoinColumn(name = "idCotizacion")
    private Cotizaciones cotizaciones;
    @OneToOne
    @JoinColumn(name = "idEnvio")
    private Envios envios;

    //Constructores

    public Ventas() {
    }

    public Ventas(Integer idVenta, DateFormat fechaVenta, Cotizaciones cotizaciones, Envios envios) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.cotizaciones = cotizaciones;
        this.envios = envios;
    }

    //Getter y Setter

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public DateFormat getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(DateFormat fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Cotizaciones getCotizaciones() {
        return cotizaciones;
    }

    public void setCotizaciones(Cotizaciones cotizaciones) {
        this.cotizaciones = cotizaciones;
    }

    public Envios getEnvios() {
        return envios;
    }

    public void setEnvios(Envios envios) {
        this.envios = envios;
    }
}
