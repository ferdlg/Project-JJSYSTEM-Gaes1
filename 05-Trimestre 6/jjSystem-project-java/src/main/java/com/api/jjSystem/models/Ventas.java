package com.api.jjSystem.models;

import jakarta.persistence.*;

import java.text.DateFormat;

@Entity
@Table(name = "Ventas")

public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private Integer id;

    private DateFormat fechaVenta;

    public Ventas() {
    }

    public Ventas(Integer id, DateFormat fechaVenta) {
        this.id = id;
        this.fechaVenta = fechaVenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DateFormat getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(DateFormat fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
