package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "DetallesVentas")

public class DetallesVentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleVenta")
    private Integer idDetalleVenta;

    private String detallesVenta;

    private Float subtotaleVenta;

    private Float totalVenta;

    public DetallesVentas() {
    }

    public DetallesVentas(Integer idDetalleVenta, String detallesVenta, Float subtotaleVenta, Float totalVenta) {
        this.idDetalleVenta = idDetalleVenta;
        this.detallesVenta = detallesVenta;
        this.subtotaleVenta = subtotaleVenta;
        this.totalVenta = totalVenta;
    }

    public Integer getId() {
        return idDetalleVenta;
    }

    public void setId(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
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
