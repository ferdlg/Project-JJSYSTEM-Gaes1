package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "DetallesVentas")

public class DetallesVentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleVenta")
    private Integer id;
    @Column(name = "detallesVenta")
    private String detallesVenta;
    @Column(name = "subtotalVenta")
    private Float subtotalVenta;
    @Column(name = "totalVenta")
    private Float totalVenta;
    @OneToOne
    @JoinColumn(name = "Ventas_idVenta")
    private Ventas ventas;

    //Constructores

    public DetallesVentas() {
    }

    public DetallesVentas(Integer id, String detallesVenta, Float subtotaleVenta, Float totalVenta, Ventas ventas) {
        this.id = id;
        this.detallesVenta = detallesVenta;
        this.subtotalVenta = subtotaleVenta;
        this.totalVenta = totalVenta;
        this.ventas = ventas;
    }

    //Getter y Setter

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

    public Float getSubtotalVenta() {
        return subtotalVenta;
    }

    public void setSubtotalVenta(Float subtotalVenta) {
        this.subtotalVenta = subtotalVenta;
    }

    public Float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }
}
