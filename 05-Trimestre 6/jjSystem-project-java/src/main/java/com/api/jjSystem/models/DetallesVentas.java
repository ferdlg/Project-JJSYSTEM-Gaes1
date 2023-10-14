package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "DetallesVentas")

public class DetallesVentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleVenta")
    private Integer id;

    private String detallesVenta;

    private Float subtotaleVenta;

    private Float totalVenta;

    public DetallesVentas() {
    }

    public DetallesVentas(Integer id, String detallesVenta, Float subtotaleVenta, Float totalVenta) {
        this.id = id;
        this.detallesVenta = detallesVenta;
        this.subtotaleVenta = subtotaleVenta;
        this.totalVenta = totalVenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(String detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    public Float getSubtotaleVenta() {
        return subtotaleVenta;
    }

    public void setSubtotaleVenta(Float subtotaleVenta) {
        this.subtotaleVenta = subtotaleVenta;
    }

    public Float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Float totalVenta) {
        this.totalVenta = totalVenta;
    }
}
