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

    private DateFormat fechaVenta;

    public Ventas() {
    }

    public Ventas(Integer idVenta, DateFormat fechaVenta) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
    }

    public Integer getId() {
        return idVenta;
    }

    public void setId(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public DateFormat getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(DateFormat fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
