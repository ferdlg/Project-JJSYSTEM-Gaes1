package com.api.jjSystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicios")

public class Servicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServicio")
    private Integer idServicio;
    @Column(name = "nombreServicio")
    private String nombreServicio;
    @Column(name = "descripcionServicio")
    private String descripcionServicio;
    @ManyToOne
    @JoinColumn(name = "Cotizacion_idCotizacion")
    private Cotizaciones cotizaciones;
    @OneToOne
    @JoinColumn(name = "idCategoriaServicio")
    private CategoriasServicios categoriasServicios;

    public Servicios() {
    }

    public Servicios(Integer idServicio, String nombreServicio, String descripcionServicio, Cotizaciones cotizaciones, CategoriasServicios categoriasServicios) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;
        this.cotizaciones = cotizaciones;
        this.categoriasServicios = categoriasServicios;
    }

    //Getter y Setter

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public Cotizaciones getCotizaciones() {
        return cotizaciones;
    }

    public void setCotizaciones(Cotizaciones cotizaciones) {
        this.cotizaciones = cotizaciones;
    }

    public CategoriasServicios getCategoriaServicios() {
        return categoriasServicios;
    }

    public void setCategoriaServicios(CategoriasServicios categoriasServicios) {
        this.categoriasServicios = categoriasServicios;
    }
}
